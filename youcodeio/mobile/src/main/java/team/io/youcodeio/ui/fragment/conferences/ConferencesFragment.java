package team.io.youcodeio.ui.fragment.conferences;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import team.io.youcodeio.R;
import team.io.youcodeio.model.conferences.ConferencesModel;
import team.io.youcodeio.ui.adapter.conferences.ConferencesRecyclerViewAdapter;

/**
 * Created by stevenwatremez on 11/01/16.
 *
 */
public class ConferencesFragment extends Fragment {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ConferencesModel.Builder mConferencesModelBuilder;
    private List<ConferencesModel> mListConferencesModel;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.conferences_recycler_view)
    RecyclerView mConferencesRecyclerView;

    @BindString(R.string.drawer_menu_conferences)
    String mConferencesToolbarTitle;
    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ConferencesFragment() {}

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_conferences, container, false);
        initUI();
        return mRootView;
    }

    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/

    private void initUI() {
        ButterKnife.bind(this, mRootView);
        // set the action Bar title
        getActivity().setTitle(mConferencesToolbarTitle);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mConferencesRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mConferencesRecyclerView.setLayoutManager(mLayoutManager);

        // FIXME : call the Conference WS to retrieve the data
        createFakeConferencesdata();

        mAdapter = new ConferencesRecyclerViewAdapter(mListConferencesModel);
        mConferencesRecyclerView.setAdapter(mAdapter);
    }

    private void createFakeConferencesdata() {
        Map<String, String> conferencesYearMap = new HashMap<>();
        mListConferencesModel = new ArrayList<>();

        // FIXME DATA 1
        mConferencesModelBuilder = new ConferencesModel.Builder();

        conferencesYearMap.put("2014", "http://youcode.io/#/home");
        conferencesYearMap.put("2015", "http://youcode.io/#/home");

        mConferencesModelBuilder
                .setTitle("Google I/O")
                .setSubtitle("An annual software developer-focused conference held by Google in San Francisco, California.")
                .setConferencesYear(conferencesYearMap);

        mListConferencesModel.add(mConferencesModelBuilder.build());


        // FIXME DATA 2
        conferencesYearMap = new HashMap<>();
        mConferencesModelBuilder = new ConferencesModel.Builder();

        conferencesYearMap.put("2014", "http://youcode.io/#/home");
        conferencesYearMap.put("2015", "http://youcode.io/#/home");

        mConferencesModelBuilder
                .setTitle("DotGo")
                .setSubtitle("The European Go conference.")
                .setConferencesYear(conferencesYearMap);

        mListConferencesModel.add(mConferencesModelBuilder.build());


        // FIXME DATA 3
        conferencesYearMap = new HashMap<>();
        mConferencesModelBuilder = new ConferencesModel.Builder();

        conferencesYearMap.put("2014", "http://youcode.io/#/home");
        conferencesYearMap.put("2015", "http://youcode.io/#/home");

        mConferencesModelBuilder
                .setTitle("DotJS")
                .setSubtitle("The European JS conference.")
                .setConferencesYear(conferencesYearMap);

        mListConferencesModel.add(mConferencesModelBuilder.build());

        // FIXME DATA 4
        conferencesYearMap = new HashMap<>();
        mConferencesModelBuilder = new ConferencesModel.Builder();

        conferencesYearMap.put("2014", "http://youcode.io/#/home");
        conferencesYearMap.put("2015", "http://youcode.io/#/home");

        mConferencesModelBuilder
                .setTitle("DotScale")
                .setSubtitle("The European Tech Conference on Scalability.")
                .setConferencesYear(conferencesYearMap);

        mListConferencesModel.add(mConferencesModelBuilder.build());

        // FIXME DATA 5
        conferencesYearMap = new HashMap<>();
        mConferencesModelBuilder = new ConferencesModel.Builder();

        conferencesYearMap.put("2014", "http://youcode.io/#/home");
        conferencesYearMap.put("2015", "http://youcode.io/#/home");

        mConferencesModelBuilder
                .setTitle("DotScale")
                .setSubtitle("The European Tech Conference on Scalability.")
                .setConferencesYear(conferencesYearMap);

        mListConferencesModel.add(mConferencesModelBuilder.build());

        // FIXME DATA 6
        conferencesYearMap = new HashMap<>();
        mConferencesModelBuilder = new ConferencesModel.Builder();

        conferencesYearMap.put("2014", "http://youcode.io/#/home");
        conferencesYearMap.put("2015", "http://youcode.io/#/home");

        mConferencesModelBuilder
                .setTitle("ng-conf")
                .setSubtitle("The World's Original Angular Conference.")
                .setConferencesYear(conferencesYearMap);

        mListConferencesModel.add(mConferencesModelBuilder.build());

        // FIXME DATA 7
        conferencesYearMap = new HashMap<>();
        mConferencesModelBuilder = new ConferencesModel.Builder();

        conferencesYearMap.put("2014", "http://youcode.io/#/home");
        conferencesYearMap.put("2015", "http://youcode.io/#/home");

        mConferencesModelBuilder
                .setTitle("FOSDEM")
                .setSubtitle("OSDEM is a free event for software developers to meet, share ideas and collaborate.")
                .setConferencesYear(conferencesYearMap);

        mListConferencesModel.add(mConferencesModelBuilder.build());
    }
}
