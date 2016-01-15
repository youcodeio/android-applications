package team.io.youcodeio.ui.fragment.search;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import team.io.youcodeio.R;

/**
 * Created by stevenwatremez on 10/01/16.
 *
 */
public class SearchFragment extends Fragment implements MaterialSearchView.OnQueryTextListener, MaterialSearchView.SearchViewListener {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.search_view)
    MaterialSearchView mSearchView;

    @BindString(R.string.drawer_menu_search)
    String mSearchToolBarTitle;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public SearchFragment() {}

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

        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(item);

    }

    /*****************************************************************
     * IMPLEMENTS METHOD
     ****************************************************************/
    @Override
    public boolean onQueryTextSubmit(String query) {
        Snackbar.make(getActivity().findViewById(R.id.container), "Query: " + query, Snackbar.LENGTH_LONG)
                .show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onSearchViewShown() {

    }

    @Override
    public void onSearchViewClosed() {

    }

    /*****************************************************************
     * PUBLIC METHOD
     ****************************************************************/

    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/
    private void initUI() {
        ButterKnife.bind(this, mRootView);
        // set the action Bar title
        getActivity().setTitle(mSearchToolBarTitle);
        setMenuVisibility(true);
        mSearchView.setVoiceSearch(false);
        //mSearchView.setCursorDrawable(R.drawable.custom_cursor);
        mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        mSearchView.setOnQueryTextListener(this);

        mSearchView.setOnSearchViewListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE ) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    mSearchView.setQuery(searchWrd, false);
                }
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
}
