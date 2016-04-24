package team.io.youcodeio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import team.io.youcodeio.R;
import team.io.youcodeio.model.conferences.Conference;
import team.io.youcodeio.model.conferences.ConferenceSessions;
import team.io.youcodeio.ui.adapter.conferences.ConferencesRecyclerViewAdapter;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public class ConferencesActivity extends AbsActivity {

    /*****************************************************************
     * DATA
     ****************************************************************/
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
     * STARTER
     ****************************************************************/
    public static void start(Context context) {
        Intent starter = new Intent(context, ConferencesActivity.class);
        context.startActivity(starter);
    }

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_conferences;
    }

    @Override
    protected String setToolbarTitle() {
        return getString(R.string.drawer_menu_conferences);
    }

    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/

    private void initUI() {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mConferencesRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
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
