package team.io.youcodeio.ui.activity.channels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import team.io.youcodeio.model.search.VideoFromSearch;
import team.io.youcodeio.services.YoucodeServer;
import team.io.youcodeio.ui.adapter.search.SearchRecyclerViewAdapter;

/**
 * Created by steven_watremez on 24/04/16.
 *
 */
public class ChannelLatestVideosActivity extends AppCompatActivity {

    /*****************************************************************
     * STATIC
     ****************************************************************/
    final private static String BUNDLE_CHANNEL_ID = "BUNDLE_CHANNEL_ID";

    /*****************************************************************
     * DATA
     ****************************************************************/
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Subscription mSubscription;

    @InjectExtra(BUNDLE_CHANNEL_ID)
    String mChannelId;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.channel_latest_videos_recycler_view)
    RecyclerView mChannelLatestVideosRecyclerView;

    /*****************************************************************
     * STARTER
     ****************************************************************/
    public static void start(@NonNull final  Context context, final String channelId) {
        Intent starter = new Intent(context, ChannelLatestVideosActivity.class);
        starter.putExtra(BUNDLE_CHANNEL_ID ,channelId);
        context.startActivity(starter);
    }

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_latest_videos);
        ButterKnife.bind(this);
        Dart.inject(this);
        initUI();
    }

    private void initUI() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mChannelLatestVideosRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mChannelLatestVideosRecyclerView.setLayoutManager(mLayoutManager);

        Bundle bundle = getIntent().getExtras(); // getArguments() for a Fragment
        mChannelId = Dart.get(bundle, BUNDLE_CHANNEL_ID); // User implements Parcelable
        callChannelWSWithChannelId(mChannelId);
    }

    private void callChannelWSWithChannelId(final String channelId) {
        mSubscription = getSearchSubscription(channelId);
    }

    private Subscription getSearchSubscription(final String channelId) {
        return YoucodeServer.getService().getChannelLatestVideos(channelId)
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
                mChannelLatestVideosRecyclerView.setAdapter(mAdapter);
            }
        };
    }
}
