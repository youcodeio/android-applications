package team.io.youcodeio.ui.adapter.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

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
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
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
