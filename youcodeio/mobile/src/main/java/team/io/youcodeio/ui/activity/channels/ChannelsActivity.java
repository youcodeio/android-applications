package team.io.youcodeio.ui.activity.channels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import butterknife.Bind;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import team.io.youcodeio.R;
import team.io.youcodeio.model.channel.Channel;
import team.io.youcodeio.services.YoucodeServer;
import team.io.youcodeio.ui.activity.AbsActivity;
import team.io.youcodeio.ui.adapter.channel.ChannelRecylcerViewAdapter;
import team.io.youcodeio.ui.adapter.channel.ChannelsPagerAdapter;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public class ChannelsActivity extends AbsActivity {
    /*****************************************************************
     * DATA
     ****************************************************************/
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Channel mChannel;
    private List<Channel> mListChannel;
    private Subscription mSubscription;
    FragmentPagerAdapter adapterViewPager;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.vpPager)
    ViewPager mChannelsViewPager;

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
        initUI();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_channel;
    }

    @Override
    protected String setToolbarTitle() {
        return getString(R.string.drawer_menu_channels);
    }

    @Override
    public void onDestroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
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
        /*mChannelsRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mChannelsRecyclerView.setLayoutManager(mLayoutManager);

        // TODO : to limit the WS call, use Realm to store in database and retreive during the application life cycle
        callTheChannelWebService();
*/
/*
        adapterViewPager = new ChannelsPagerAdapter(getSupportFragmentManager());
        mChannelsViewPager.setAdapter(adapterViewPager);*/

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Talks"));
        tabLayout.addTab(tabLayout.newTab().setText("Tuts"));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        final ChannelsPagerAdapter adapter = new ChannelsPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
                //mAdapter = new ChannelRecylcerViewAdapter(channels);
                //mChannelsRecyclerView.setAdapter(mAdapter);
                Log.e("CHANNEL WS CALL", channels.toString());
            }
        };
    }

}
