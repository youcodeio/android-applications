package team.io.youcodeio.ui.adapter.channel;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import team.io.youcodeio.ui.fragment.channels.ChannelTalksFragment;
import team.io.youcodeio.ui.fragment.channels.ChannelTutsFragment;

/**
 * Created by steven_watremez on 24/04/16.
 *
 */
public class ChannelsPagerAdapter extends FragmentPagerAdapter {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private static int mNumberOfPage;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ChannelsPagerAdapter(@NonNull final FragmentManager fragmentManager, final int numberOfPage) {
        super(fragmentManager);
        mNumberOfPage = numberOfPage;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    // Returns total number of pages
    @Override
    public int getCount() {
        return mNumberOfPage;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0
                return ChannelTalksFragment.newInstance();
            case 1: // Fragment # 1
                return ChannelTutsFragment.newInstance();
            default:
                return null;
        }
    }
}
