package team.io.youcodeio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
 * Created by steven_watremez on 23/04/16.
 *
 */
public class SearchActivity extends AppCompatActivity {

    /*****************************************************************
     * STATIC
     ****************************************************************/
    final private static String BUNDLE_QUERY = "BUNDLE_QUERY";

    /*****************************************************************
     * DATA
     ****************************************************************/
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Subscription mSubscription;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.search_recycler_view)
    RecyclerView mSearchRecyclerView;

    /*****************************************************************
     * STARTER
     ****************************************************************/
    public static void start(Context context) {
        Intent starter = new Intent(context, SearchActivity.class);
        context.startActivity(starter);
    }
    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    protected void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);
        ButterKnife.bind(this);
        initUI();
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

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mSearchRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mSearchRecyclerView.setLayoutManager(mLayoutManager);

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

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Search> searchList) {
                mAdapter = new SearchRecyclerViewAdapter(searchList);
                mSearchRecyclerView.setAdapter(mAdapter);
            }
        };
    }
}
