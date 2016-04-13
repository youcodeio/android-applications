package team.io.youcodeio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
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

public class HomeActivity extends AppCompatActivity {

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
     * STARTER
     * *********************************************************************************************
     ****/
    public static void start(Context context) {
        Intent starter = new Intent(context, HomeActivity.class);
        //starter.addFlags(starter.FLAG_ACTIVITY_NO_ANIMATION);
        context.startActivity(starter);
    }

    /****
     * **********************************************************************************************
     * LIFE CYCLE
     * *********************************************************************************************
     ****/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
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
     * PRIVATE METHODS
     * **********************************************************************************************
     ****/
    private void initUI() {
        initBottomBar();
    }


    /****
     * **********************************************************************************************
     * IMPLEMENTS METHODS
     * *********************************************************************************************
     ****/

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
