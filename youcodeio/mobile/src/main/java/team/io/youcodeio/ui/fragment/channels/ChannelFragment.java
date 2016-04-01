package team.io.youcodeio.ui.fragment.channels;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import team.io.youcodeio.R;
import team.io.youcodeio.model.channel.Channel;
import team.io.youcodeio.services.YoucodeServer;
import team.io.youcodeio.ui.adapter.channel.ChannelRecylcerViewAdapter;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class ChannelFragment extends Fragment {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Channel mChannel;
    private List<Channel> mListChannel;
    private Subscription mSubscription;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.conferences_recycler_view)
    RecyclerView mConferencesRecyclerView;

    @BindString(R.string.drawer_menu_channels)
    String mConferencesToolbarTitle;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ChannelFragment() {
    }

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_conferences, container, false);
        mSubscription = getChannelObservable();
        initUI();
        return mRootView;
    }

    @Override
    public void onDestroy() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        super.onDestroy();
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

        callTheChannelWebService();
    }

    private void callTheChannelWebService() {

    }

    private Subscription getChannelObservable() {
        return YoucodeServer.getService().getChannels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getChannelSubscriber());
    }

    private Subscriber<List<Channel>> getChannelSubscriber() {
        return new Subscriber<List<Channel>>() {
            @Override
            public void onCompleted() {
                showSuccessSnackBar();
            }

            @Override
            public void onError(Throwable e) {
                showErrorSnackBar(e.getMessage());
            }

            @Override
            public void onNext(List<Channel> channels) {
                mAdapter = new ChannelRecylcerViewAdapter(channels);
                mConferencesRecyclerView.setAdapter(mAdapter);
                Log.e("CHANNEL WS CALL", channels.toString());
            }
        };
    }

    private void showErrorSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(mRootView, message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        sbView.setBackgroundColor(Color.RED);
        snackbar.show();
    }

    private void showSuccessSnackBar() {
        Snackbar snackbar = Snackbar.make(mRootView, "Everthing ok", Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        sbView.setBackgroundColor(Color.GREEN);
        snackbar.show();
    }
}
