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
import android.widget.Button;
import android.widget.FrameLayout;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import team.io.youcodeio.ui.activity.AboutActivity;
import team.io.youcodeio.ui.activity.ChannelsActivity;
import team.io.youcodeio.ui.activity.ConfActivity;
import team.io.youcodeio.ui.activity.SearchActivity;
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

    /****
     * **********************************************************************************************
     * UI
     * *********************************************************************************************
     ****/
    @Bind(R.id.about_button)
    Button aboutButton;

    @Bind(R.id.conf_button)
    Button confButton;

    @Bind(R.id.channels_button)
    Button channelsButton;

    @Bind(R.id.search_button)
    Button searchButton;

    /****
     * **********************************************************************************************
     * STARTER
     * *********************************************************************************************
     ****/
    public static void start(Context context) {
        Intent starter = new Intent(context, HomeActivity.class);
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
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    public void onBackPressed() {
        /*if (mMaterialSearchView.isSearchOpen()) {
            mMaterialSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }*/
    }
    /****
     * **********************************************************************************************
     * USER INTERACTION METHODS
     * *********************************************************************************************
     ****/
    @OnClick(R.id.about_button)
    public void onClickAboutButton() {
        AboutActivity.start(this);
    }

    @OnClick(R.id.conf_button)
    public void onClickConfButton() {
        ConfActivity.start(this);
    }

    @OnClick(R.id.channels_button)
    public void onClickChannelsButton() {
        ChannelsActivity.start(this);
    }

    @OnClick(R.id.search_button)
    public void onClickSearchButton() {
        SearchActivity.start(this);
    }


    /****
     * **********************************************************************************************
     * PRIVATE METHODS
     * **********************************************************************************************
     ****/
    private void initUI() {
        //initBottomBar();
        //mMaterialSearchView.setOnQueryTextListener(this);
    }
}
