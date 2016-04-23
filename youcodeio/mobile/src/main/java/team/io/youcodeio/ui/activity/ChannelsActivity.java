package team.io.youcodeio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import team.io.youcodeio.R;
import team.io.youcodeio.helper.HandleErrorHelper;
import team.io.youcodeio.model.channel.Channel;
import team.io.youcodeio.services.YoucodeServer;
import team.io.youcodeio.ui.adapter.channel.ChannelRecylcerViewAdapter;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public class ChannelsActivity extends AppCompatActivity {
    /*****************************************************************
     * DATA
     ****************************************************************/
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Channel mChannel;
    private List<Channel> mListChannel;
    private Subscription mSubscription;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.conferences_recycler_view)
    RecyclerView mConferencesRecyclerView;

    /*****************************************************************
     * STARTER
     ****************************************************************/
    public static void start(Context context) {
        Intent starter = new Intent(context, ChannelsActivity.class);
        context.startActivity(starter);
    }

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_conferences);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    public void onDestroy() {
        if (!mSubscription.isUnsubscribed()) {
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
        mConferencesRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mConferencesRecyclerView.setLayoutManager(mLayoutManager);

        // TODO : to limit the WS call, use Realm to store in database and retreive during the application life cycle
        callTheChannelWebService();
    }

    private void callTheChannelWebService() {
        mSubscription = getChannelSubscription();
    }

    private Subscription getChannelSubscription() {
        return YoucodeServer.getService().getChannels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getChannelSubscriber());
    }

    private Subscriber<List<Channel>> getChannelSubscriber() {
        return new Subscriber<List<Channel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {


            }

            @Override
            public void onNext(List<Channel> channels) {
                mAdapter = new ChannelRecylcerViewAdapter(channels);
                mConferencesRecyclerView.setAdapter(mAdapter);
                Log.e("CHANNEL WS CALL", channels.toString());
            }
        };
    }

}