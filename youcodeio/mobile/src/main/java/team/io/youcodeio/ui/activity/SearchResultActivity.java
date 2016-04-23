package team.io.youcodeio.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import team.io.youcodeio.R;
import team.io.youcodeio.model.search.Search;
import team.io.youcodeio.services.YoucodeServer;
import team.io.youcodeio.ui.adapter.search.SearchRecyclerViewAdapter;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public class SearchResultActivity extends Activity {

    /*****************************************************************
     * STATIC
     ****************************************************************/
    final private static String BUNDLE_QUERY_TEXT_TEST = "BUNDLE_QUERY_TEXT_TEST";

    /*****************************************************************
     * DATA
     ****************************************************************/
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Subscription mSubscription;

    @InjectExtra(BUNDLE_QUERY_TEXT_TEST)
    String mQuery;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.search_recycler_view)
    RecyclerView mSearchRecyclerView;

    /*****************************************************************
     * STARTER
     ****************************************************************/
    public static void start(@NonNull final Activity context, @NonNull final String query) {
        Intent starter = new Intent(context, SearchResultActivity.class);
        starter.putExtra(BUNDLE_QUERY_TEXT_TEST, query);
        context.startActivity(starter);
    }

    /*
     *****************************************************************
     * LIFE CYCLE
     ***************************************************************
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dart.inject(this);
        setContentView(R.layout.activity_search_result);
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

        Bundle bundle = getIntent().getExtras(); // getArguments() for a Fragment
        String query = Dart.get(bundle, BUNDLE_QUERY_TEXT_TEST); // User implements Parcelable
        callSearchWSWithQuery(query);
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
