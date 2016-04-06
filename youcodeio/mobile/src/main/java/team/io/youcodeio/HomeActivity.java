package team.io.youcodeio;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import team.io.youcodeio.ui.fragment.about.AboutFragment;
import team.io.youcodeio.ui.fragment.channels.ChannelFragment;
import team.io.youcodeio.ui.fragment.conferences.ConferencesFragment;
import team.io.youcodeio.ui.fragment.search.SearchFragment;

@TargetApi(Build.VERSION_CODES.M)
public class HomeActivity extends AppCompatActivity implements View.OnScrollChangeListener {

    /****
     * **********************************************************************************************
     * DATA
     * *********************************************************************************************
     ****/
    private BottomBar mBottomBar;
    private Bundle mSavedInstanceState;

    /****
     * **********************************************************************************************
     * UI
     * *********************************************************************************************
     ****/
    @Bind(R.id.home_layout) CoordinatorLayout mCoordinatorLayout;
    @Bind(R.id.fragment_container) FrameLayout mFragmentContainer;
    @Bind(R.id.floating_search_view) FloatingSearchView mFloatingSearchView;

    /****
     * **********************************************************************************************
     * LIFE CYCLE
     * *********************************************************************************************
     ****/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        //mSearchView.setMenuItem(item);
        return true;
    }

    @Override
    public void onBackPressed() {
        /*if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
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

    private static final int HIDE_THRESHOLD = 20;
    private int scrolledDistance = 0;
    private boolean controlsVisible = true;

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
            hideViews();
            controlsVisible = false;
            scrolledDistance = 0;
        } else if (scrolledDistance < -HIDE_THRESHOLD && !controlsVisible) {
            showViews();
            controlsVisible = true;
            scrolledDistance = 0;
        }

        if((controlsVisible && scrollY>0) || (!controlsVisible && scrollY<0)) {
            scrolledDistance += scrollY;
        }
    }

    private void hideViews() {
        mFloatingSearchView.animate().translationY(-mFloatingSearchView.getHeight()).setInterpolator(new AccelerateInterpolator(2));
/*
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFabButton.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        mFabButton.animate().translationY(mFabButton.getHeight()+fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();*/
    }

    private void showViews() {
        mFloatingSearchView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        //mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

    /****
     * **********************************************************************************************
     * PRIVATE METHODS
     * **********************************************************************************************
     ****/
    @TargetApi(Build.VERSION_CODES.M)
    private void initUI() {
        initBottomBar();

        mFragmentContainer.setOnScrollChangeListener(this);
    }

    private void initBottomBar() {
        mBottomBar = BottomBar.attachShy(mCoordinatorLayout, mFragmentContainer, mSavedInstanceState);
        //mBottomBar.setActiveTabColor("#ff3d3d");
        mBottomBar.setItemsFromMenu(R.menu.menu_bottom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

                Fragment fragment;
                switch (menuItemId) {
                    case R.id.bottomBarItemOne:
                        fragment = new AboutFragment();
                        break;
                    case R.id.bottomBarItemTwo:
                        fragment = new ChannelFragment();
                        break;
                    case R.id.bottomBarItemThree:
                        fragment = SearchFragment.newInstance("Android");
                        break;
                    case R.id.bottomBarItemFour:
                        fragment = new ConferencesFragment();
                        break;
                    default:
                        fragment = SearchFragment.newInstance("Android");
                        break;
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment).commit();
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bottomBarItemOne:
                        break;
                    case R.id.bottomBarItemTwo:
                        break;
                    case R.id.bottomBarItemThree:
                        break;
                    case R.id.bottomBarItemFour:
                        break;
                    default:
                        break;
                }
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.grey));
        mBottomBar.mapColorForTab(2, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(3, ContextCompat.getColor(this, R.color.black));
    }
}
