package team.io.youcodeio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.model.HelpLiveo;
import br.liveo.model.Navigation;
import br.liveo.navigationliveo.NavigationLiveo;
import team.io.youcodeio.ui.fragment.about.AboutFragment;
import team.io.youcodeio.ui.fragment.conferences.ConferencesFragment;
import team.io.youcodeio.ui.fragment.search.SearchFragment;

public class HomeActivity extends NavigationLiveo implements OnItemClickListener {

    // Creating items navigation
    HelpLiveo mHelpLiveo = new HelpLiveo();

    /***********************************************************************************************
     * LIFE CYCLE
     ***********************************************************************************************/
    @Override
    public void onInt(Bundle bundle) {
        //  TODO User Information
        /* TODO ------- create a MODEL for this information ------ */
        this.userBackground.setImageResource(R.drawable.background_drawer_menu_youcodeio);
        /* -------------------------------------------------- */

        initUI();

        //with(this, Navigation.THEME_DARK). add theme dark
        //with(this, Navigation.THEME_LIGHT). add theme light

        with(this, Navigation.THEME_DARK) // default theme is dark
                .startingPosition(0) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(R.string.action_settings, R.drawable.ic_settings_red_24dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    /***********************************************************************************************
     * LISTENERS
     ***********************************************************************************************/

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    @Override
    public void onItemClick(int i) {
        // update the main content by replacing fragments
        Fragment mFragment = null;
        switch (i) {
            case 0:
                // Launch the SearchFragment when this item on the drawer menu are selected
                //mFragment = new SearchFragment();
                mFragment = new SearchFragment();
                //SearchActivity.start(this);
                break;
            case 1:
                // TODO change this to ConferencesFragment
                //AnnonceCreationOrUpdateActivity.start(this);
                mFragment = new ConferencesFragment();
                break;
            case 2:
                // TODO change this to ChannelsFragment
                //mFragment = new MyAdsFragment();
                break;
            case 4:
                // TODO change this to AboutFragment
                //MySaveActvity.start(this);
                mFragment = new AboutFragment();
                break;

            default:
                break;
        }

        if (mFragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, mFragment).commit();
        }
    }

    /***********************************************************************************************
     * PRIVATE METHODS
     ***********************************************************************************************/

    private void initUI() {

        mHelpLiveo.add(getString(R.string.drawer_menu_search), R.drawable.ic_code_black_24dp); // Accounts List view with viewing number of account.
        mHelpLiveo.add(getString(R.string.drawer_menu_conferences), R.drawable.ic_people_black_24dp);
        mHelpLiveo.add(getString(R.string.drawer_menu_channels), R.drawable.ic_tv_black_24dp);
        mHelpLiveo.addSubHeader(getString(R.string.drawer_menu_subheader)); //Item subHeader
        mHelpLiveo.add(getString(R.string.drawer_menu_about), R.drawable.ic_info_black_24dp);
    }


}
