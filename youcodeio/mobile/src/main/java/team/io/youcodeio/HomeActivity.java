package team.io.youcodeio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import team.io.youcodeio.ui.adapter.Home.HomeViewPagerAdapter;
import team.io.youcodeio.ui.fragment.about.AboutFragment;
import team.io.youcodeio.ui.fragment.channels.ChannelFragment;
import team.io.youcodeio.ui.fragment.conferences.ConferencesFragment;
import team.io.youcodeio.ui.fragment.search.SearchFragment;

public class HomeActivity extends AppCompatActivity {


    private int[] tabIcons = {
            R.drawable.ic_code_white_24dp,
            R.drawable.ic_info_white_24dp,
            R.drawable.ic_people_white_24dp,
            R.drawable.ic_tv_white_24dp
    };

    /****
     * **********************************************************************************************
     * UI
     * *********************************************************************************************
     ****/
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;

    /****
     * **********************************************************************************************
     * LIFE CYCLE
     * *********************************************************************************************
     ****/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        setTitle(""); // delete the title of the toolbar

        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();
    }

    /****
     * **********************************************************************************************
     * CONSTRUCTOR
     * *********************************************************************************************
     ****/
    public HomeActivity() {}

    /****
     * **********************************************************************************************
     * PRIVATE METHODS
     * **********************************************************************************************
     ****/
    private void setupViewPager(ViewPager viewPager) {
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SearchFragment(), "Search");
        adapter.addFragment(new AboutFragment(), "About");
        adapter.addFragment(new ConferencesFragment(), "Conferences");
        adapter.addFragment(new ChannelFragment(), "Channels");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        for (int i = 0; i < tabIcons.length ; i++) {
            mTabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }
}
