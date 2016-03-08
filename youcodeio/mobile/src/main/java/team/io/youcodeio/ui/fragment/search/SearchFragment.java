package team.io.youcodeio.ui.fragment.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindString;
import butterknife.ButterKnife;
import team.io.youcodeio.R;

/**
 * Created by stevenwatremez on 10/01/16.
 */
public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;
    private SearchView mSearchView;

    /*****************************************************************
     * UI
     ****************************************************************/
    private MenuItem mSearchItem;

    @BindString(R.string.drawer_menu_search)
    String mSearchToolBarTitle;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public SearchFragment() {

    }

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_search, container, false);
        initUI();
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /*****************************************************************
     * PROTECTED METHOD
     ****************************************************************/
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);
        mSearchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(mSearchItem);
        mSearchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.action_search:
                // Handle this selection
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*****************************************************************
     * IMPLEMENTS METHODS
     ****************************************************************/
    @Override
    public boolean onQueryTextSubmit(String query) {
        // perform query here

        // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
        // see https://code.google.com/p/android/issues/detail?id=24599
        mSearchView.clearFocus();
        Log.e("QUERRY TEXT SUBMIT", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("QUERRY TEXT CHANGE", newText);
        return false;
    }

    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/
    private void initUI() {
        ButterKnife.bind(this, mRootView);
        // set the action Bar title
        getActivity().setTitle(mSearchToolBarTitle);
    }


//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == MaterialSearchView.REQUEST_VOICE ) {
//            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//            if (matches != null && matches.size() > 0) {
//                String searchWrd = matches.get(0);
//                if (!TextUtils.isEmpty(searchWrd)) {
//                    mSearchView.setQuery(searchWrd, false);
//                }
//            }
//            return;
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
}
