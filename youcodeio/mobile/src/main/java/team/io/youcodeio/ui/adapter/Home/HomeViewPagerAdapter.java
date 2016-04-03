package team.io.youcodeio.ui.adapter.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import team.io.youcodeio.ui.fragment.about.AboutFragment;
import team.io.youcodeio.ui.fragment.channels.ChannelFragment;
import team.io.youcodeio.ui.fragment.conferences.ConferencesFragment;
import team.io.youcodeio.ui.fragment.search.SearchFragment;

/**
 * Created by stevenwatremez on 03/04/16.
 *
 */
public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private String mQuery;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public HomeViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    /*****************************************************************
     * IMPLEMENTS METHODS
     ****************************************************************/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = SearchFragment.newInstance(mQuery);
                break;
            case 1:
                fragment = new AboutFragment();
                break;
            case 2:
                fragment = new ConferencesFragment();
                break;
            case 3:
                fragment = new ChannelFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void setQuery(final String query){
        mQuery = query;
    }

    public void setupFragmentAndTitle() {
        addFragment(new SearchFragment(), "Search");
        addFragment(new AboutFragment(), "About");
        addFragment(new ConferencesFragment(), "Conferences");
        addFragment(new ChannelFragment(), "Channels");
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
