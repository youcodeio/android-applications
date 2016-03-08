package team.io.youcodeio.ui.fragment.channels;

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
import team.io.youcodeio.model.channel.ChannelModel;
import team.io.youcodeio.ui.adapter.channel.ChannelRecylcerViewAdapter;

/**
 * Created by stevenwatremez on 15/01/16.
 */
public class ChannelFragment extends Fragment {


    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ChannelModel.Builder mChannelModelBuilder;
    private List<ChannelModel> mListChannelModel;

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
     * PROTECTED METHOD
     ****************************************************************/

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

        // FIXME : call the Channel WS to retrieve the data
        createFakeChanneldata();

        mAdapter = new ChannelRecylcerViewAdapter(mListChannelModel);
        mConferencesRecyclerView.setAdapter(mAdapter);
    }

    private void createFakeChanneldata() {
        mListChannelModel = new ArrayList<>();

        // FIXME DATA 1
        mChannelModelBuilder = new ChannelModel.Builder();

        mChannelModelBuilder
                .setTitle("vaadinofficial")
                .setDescription("This is the official Vaadin channel. We will post our videos, tutorials and webinars through this channel.");

        mListChannelModel.add(mChannelModelBuilder.build());

        // FIXME DATA 2
        mChannelModelBuilder = new ChannelModel.Builder();

        mChannelModelBuilder
                .setTitle("Docker")
                .setDescription("Docker is an open platform for developers and SysAdmins to build, ship and run distributed applications.");

        mListChannelModel.add(mChannelModelBuilder.build());

        // FIXME DATA 3
        mChannelModelBuilder = new ChannelModel.Builder();

        mChannelModelBuilder
                .setTitle("Grafikart.fr")
                .setDescription("Retrouvez un concentré du web autour du monde du développement web et du graphisme...");

        mListChannelModel.add(mChannelModelBuilder.build());
    }
}
