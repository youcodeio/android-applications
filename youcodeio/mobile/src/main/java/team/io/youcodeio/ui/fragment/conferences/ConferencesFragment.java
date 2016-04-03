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
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import team.io.youcodeio.R;
import team.io.youcodeio.model.conferences.Conference;
import team.io.youcodeio.model.conferences.ConferenceSessions;
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
    private Conference mConference;
    private List<Conference> mListConferences;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.conferences_recycler_view)
    RecyclerView mConferencesRecyclerView;

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

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mConferencesRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mConferencesRecyclerView.setLayoutManager(mLayoutManager);

        // FIXME : call the Conference WS to retrieve the data
        createFakeConferencesdata();

        mAdapter = new ConferencesRecyclerViewAdapter(mListConferences);
        mConferencesRecyclerView.setAdapter(mAdapter);
    }

    private void createFakeConferencesdata() {
        List<ConferenceSessions> conferenceSessionsList = new ArrayList<>();
        mListConferences = new ArrayList<>();

        // FIXME DATA 1
        conferenceSessionsList.add(new ConferenceSessions("2014", "http://youcode.io/#/home"));
        conferenceSessionsList.add(new ConferenceSessions("2015", "http://youcode.io/#/home"));

        mConference = new Conference(
                "1",
                "Google I/O",
                "An annual software developer-focused conference held by Google in San Francisco, California.",
                conferenceSessionsList);

        mListConferences.add(mConference);

        // FIXME DATA 2
        mConference = new Conference(
                "1",
                "Google I/O",
                "An annual software developer-focused conference held by Google in San Francisco, California.",
                conferenceSessionsList);

        mListConferences.add(mConference);


        // FIXME DATA 3
        mConference = new Conference(
                "1",
                "Google I/O",
                "An annual software developer-focused conference held by Google in San Francisco, California.",
                conferenceSessionsList);

        mListConferences.add(mConference);

        // FIXME DATA 4
        mConference = new Conference(
                "1",
                "Google I/O",
                "An annual software developer-focused conference held by Google in San Francisco, California.",
                conferenceSessionsList);

        mListConferences.add(mConference);

        // FIXME DATA 5
        mConference = new Conference(
                "1",
                "Google I/O",
                "An annual software developer-focused conference held by Google in San Francisco, California.",
                conferenceSessionsList);

        mListConferences.add(mConference);

        // FIXME DATA 6
        mConference = new Conference(
                "1",
                "Google I/O",
                "An annual software developer-focused conference held by Google in San Francisco, California.",
                conferenceSessionsList);
        mListConferences.add(mConference);

        // FIXME DATA 7
        mConference = new Conference(
                "1",
                "Google I/O",
                "An annual software developer-focused conference held by Google in San Francisco, California.",
                conferenceSessionsList);
        mListConferences.add(mConference);
    }
}
