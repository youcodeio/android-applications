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
public class ChannelsActivity extends AbsActivity implements TabLayout.OnTabSelectedListener {

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.vpPager)
    ViewPager mChannelsViewPager;

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;

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

    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/
    private void initUI() {
        mTabLayout.addTab(mTabLayout.newTab().setText("Talks"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tuts"));

        final ChannelsPagerAdapter adapter = new ChannelsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mChannelsViewPager.setAdapter(adapter);
        mChannelsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(this);
    }

    /*****************************************************************
     * IMPLEMENTS METHODS
     ****************************************************************/
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mChannelsViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
