package team.io.youcodeio.ui.fragment.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;
import com.f2prateek.dart.Nullable;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import team.io.youcodeio.R;
import team.io.youcodeio.helper.HandleErrorHelper;
import team.io.youcodeio.model.search.Search;
import team.io.youcodeio.services.YoucodeServer;
import team.io.youcodeio.ui.adapter.search.SearchRecyclerViewAdapter;

/**
 * Created by stevenwatremez on 10/01/16.
 *
 */
public class SearchFragment extends Fragment {

    /*****************************************************************
     * STATIC
     ****************************************************************/
    final private static String BUNDLE_QUERY = "BUNDLE_QUERY";

    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Subscription mSubscription;

    @Nullable
    @InjectExtra(BUNDLE_QUERY)
    String mQuery;

    public static SearchFragment newInstance(final String query) {

        Bundle args = new Bundle();
        args.putString(BUNDLE_QUERY, query);

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }
    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.search_recycler_view)
    RecyclerView mSearchRecyclerView;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public SearchFragment() {}

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_search, container, false);
        initUI();
        return mRootView;
    }

    @Override
    public void onDestroy() {
        if (mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        super.onDestroy();
    }

    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/
    private void initUI() {
        ButterKnife.bind(this, mRootView);
        Dart.inject(getActivity());

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mSearchRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mSearchRecyclerView.setLayoutManager(mLayoutManager);

        if (mQuery != null) {
            HandleErrorHelper.showSuccessSnackBar(mRootView, mQuery);
        }

        callSearchWSWithQuery("Android");
    }

    private void callSearchWSWithQuery(final String query) {
        mSubscription = getSearchSubscription(query);
    }

    private Subscription getSearchSubscription(final String query) {
        return YoucodeServer.getService().launchSearch(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getSearchSubscriber());
    }

    private Subscriber<List<Search>> getSearchSubscriber() {
        return new Subscriber<List<Search>>() {
            @Override
            public void onCompleted() {
                HandleErrorHelper.showSuccessSnackBar(mRootView, "OK");
            }

            @Override
            public void onError(Throwable e) {
                HandleErrorHelper.showErrorSnackBar(mRootView, e.getMessage());
            }

            @Override
            public void onNext(List<Search> searchList) {
                mAdapter = new SearchRecyclerViewAdapter(searchList);
                mSearchRecyclerView.setAdapter(mAdapter);
            }
        };
    }
}
