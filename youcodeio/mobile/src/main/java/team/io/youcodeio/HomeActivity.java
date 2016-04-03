package team.io.youcodeio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.Bind;
import butterknife.ButterKnife;
import team.io.youcodeio.ui.adapter.Home.HomeViewPagerAdapter;

public class HomeActivity extends AppCompatActivity implements MaterialSearchView.OnQueryTextListener, MaterialSearchView.SearchViewListener {

    /****
     * **********************************************************************************************
     * DATA
     * *********************************************************************************************
     ****/
    private String mQuerry = "";
    private HomeViewPagerAdapter mHomeViewPagerAdapter;

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
    @Bind(R.id.home_layout) CoordinatorLayout mCoordinatorLayout;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.viewpager) ViewPager mViewPager;
    @Bind(R.id.tabs) TabLayout mTabLayout;
    @Bind(R.id.search_view) MaterialSearchView mSearchView;

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
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(item);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    /****
     * **********************************************************************************************
     * CONSTRUCTOR
     * *********************************************************************************************
     ****/
    public HomeActivity() {}

    /****
     * **********************************************************************************************
     * IMPLEMENTS METHODS
     * *********************************************************************************************
     ****/
    @Override
    public boolean onQueryTextSubmit(String query) {
        mHomeViewPagerAdapter.setQuery(query);
        mViewPager.setCurrentItem(0);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onSearchViewShown() {
        mSearchView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSearchViewClosed() {
    }

    /****
     * **********************************************************************************************
     * PRIVATE METHODS
     * **********************************************************************************************
     ****/
    private void initUI() {
        setSupportActionBar(mToolbar);

        setTitle(""); // delete the title of the toolbar
        mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setOnSearchViewListener(this);

        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();
    }

    private void setupViewPager(ViewPager viewPager) {
        mHomeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        // TODO : use strings.xml
        mHomeViewPagerAdapter.setupFragmentAndTitle();
        mHomeViewPagerAdapter.setQuery("");
        viewPager.setAdapter(mHomeViewPagerAdapter);
    }

    private void setupTabIcons() {
        for (int i = 0; i < tabIcons.length ; i++) {
            mTabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }
}
