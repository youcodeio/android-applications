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

        private static int mNumberOfPage;

        public ChannelsPagerAdapter(@NonNull final FragmentManager fragmentManager, @NonNull final int numberOfPage) {
            super(fragmentManager);
            mNumberOfPage = numberOfPage;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return mNumberOfPage;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ChannelTalksFragment.newInstance();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return ChannelTutsFragment.newInstance();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

}
