package team.io.youcodeio.ui.fragment.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import team.io.youcodeio.R;
import team.io.youcodeio.model.search.Search;
import team.io.youcodeio.ui.adapter.search.SearchRecyclerViewAdapter;

/**
 * Created by stevenwatremez on 10/01/16.
 *
 */
public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;
    private SearchView mSearchView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Search> mSearchList;
    private Search mSearch;

    /*****************************************************************
     * UI
     ****************************************************************/
    private MenuItem mSearchItem;

    @Bind(R.id.search_recycler_view)
    RecyclerView mSearchRecyclerView;

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

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mSearchRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mSearchRecyclerView.setLayoutManager(mLayoutManager);

        // FIXME : call the Conference WS to retrieve the data
        createFakeSearchdata();

        mAdapter = new SearchRecyclerViewAdapter(mSearchList);
        mSearchRecyclerView.setAdapter(mAdapter);
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

    private void createFakeSearchdata() {
        mSearchList = new ArrayList<>();

        // FIXME DATA 1
        mSearch = new Search(
                "1",
                "Titre 1 de la mort qui tue !",
                "Test du titre de la mort qui tue et qui peu rendre trop bien dans ton cul !");
        mSearchList.add(mSearch);

        // FIXME DATA 2
        mSearch = new Search(
                "2",
                "Titre 2 de la mort qui tue !",
                "Test du titre de la mort qui tue et qui peu rendre trop bien dans ton cul !");
        mSearchList.add(mSearch);

        // FIXME DATA 3
        mSearch = new Search(
                "3",
                "Titre 3 de la mort qui tue !",
                "Test du titre de la mort qui tue et qui peu rendre trop bien dans ton cul !");
        mSearchList.add(mSearch);
    }
}
