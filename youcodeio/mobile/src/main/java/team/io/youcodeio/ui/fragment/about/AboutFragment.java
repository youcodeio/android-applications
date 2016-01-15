package team.io.youcodeio.ui.fragment.about;

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
import team.io.youcodeio.model.AboutModel;
import team.io.youcodeio.ui.adapter.about.AboutRecyclerViewAdapter;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class AboutFragment extends Fragment{


    /*****************************************************************
     * DATA
     ****************************************************************/
    private View mRootView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private AboutModel.Builder mAboutModelBuilder;
    private List<AboutModel> mListAboutModel;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.about_recycler_view)
    RecyclerView mAboutRecyclerView;

    @BindString(R.string.drawer_menu_about)
    String mAboutToolbarTitle;
    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_about, container, false);
        initUI();
        return mRootView;
    }
    /*****************************************************************
     * PROTECTED METHOD
     ****************************************************************/

    /*****************************************************************
     * IMPLEMENTS METHOD
     ****************************************************************/

    /*****************************************************************
     * PUBLIC METHOD
     ****************************************************************/

    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/

    private void initUI() {
        ButterKnife.bind(this, mRootView);
        // set the action Bar title
        getActivity().setTitle(mAboutToolbarTitle);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAboutRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAboutRecyclerView.setLayoutManager(mLayoutManager);

        createFakeAboutdata();

        mAdapter = new AboutRecyclerViewAdapter(mListAboutModel);
        mAboutRecyclerView.setAdapter(mAdapter);
    }

    private void createFakeAboutdata(){
        Map<String, String> aboutYearMap = new HashMap<>();

        // FIXME DATA 1
        mListAboutModel = new ArrayList<>();
        mAboutModelBuilder = new AboutModel.Builder();

        aboutYearMap.put("2014", "http://youcode.io/#/home");
        aboutYearMap.put("2015", "http://youcode.io/#/home");

        mAboutModelBuilder
                .setName("Pierre Zemb")
                .setDescription("Hi! My name is Pierre Zemb, and I'm a French student in a graduate school of engineeringscience called ISEN where I'm currently studying Software Engineering. I'm really enjoying coding in C++, Java or Go and ship them with Docker, but I always end up developping Web apps like this one. Checkout my twitter and my website for more info!")
                .setSocialNetworkLink(aboutYearMap);

        mListAboutModel.add(mAboutModelBuilder.build());


        // FIXME DATA 2
        aboutYearMap = new HashMap<>();
        mAboutModelBuilder = new AboutModel.Builder();

        aboutYearMap.put("2014", "http://youcode.io/#/home");
        aboutYearMap.put("2015", "http://youcode.io/#/home");

        mAboutModelBuilder
                .setName("Alexis Hellouin")
                .setDescription("Hello, my name is Alexis and I am a french student in engineering school. I like web and software development, and also discovering new framework. I'm really enjoying coding in Java, Android and I try new language when I have the time (next is C++). You can check my twitter and linkedIn account for more info!")
                .setSocialNetworkLink(aboutYearMap);

        mListAboutModel.add(mAboutModelBuilder.build());


        // FIXME DATA 3
        aboutYearMap = new HashMap<>();
        mAboutModelBuilder = new AboutModel.Builder();

        aboutYearMap.put("2014", "http://youcode.io/#/home");
        aboutYearMap.put("2015", "http://youcode.io/#/home");

        mAboutModelBuilder
                .setName("Steven Watremez")
                .setDescription("Hi! My name is Steven Watremez, and I'm a French student too. In same cursus like Pierre and Alexis.I like coding for the web. It is really awesome to inovate and learn new technologies like AngularJS or Polymer. I'm web designer for my extra-activity and I like it. I designed this web app. Checkout my twitter and my website for more info!")
                .setSocialNetworkLink(aboutYearMap);

        mListAboutModel.add(mAboutModelBuilder.build());

        // FIXME DATA 4
        aboutYearMap = new HashMap<>();
        mAboutModelBuilder = new AboutModel.Builder();

        aboutYearMap.put("2014", "http://youcode.io/#/home");
        aboutYearMap.put("2015", "http://youcode.io/#/home");

        mAboutModelBuilder
                .setName("Mathieu Sallardon")
                .setDescription("Hi! My name is Mathieu Sallardon, and I'm a French student in a graduate school of engineeringscience called ISEN where I'm currently studying Software Engineering. I'm really enjoying coding in C++, Java or Go and ship them with Docker, but I always end up developping Web apps like this one. Checkout my twitter and my website for more info!")
                .setSocialNetworkLink(aboutYearMap);

        mListAboutModel.add(mAboutModelBuilder.build());


        // FIXME DATA 5
        aboutYearMap = new HashMap<>();
        mAboutModelBuilder = new AboutModel.Builder();

        aboutYearMap.put("2014", "http://youcode.io/#/home");
        aboutYearMap.put("2015", "http://youcode.io/#/home");

        mAboutModelBuilder
                .setName("Maxime Caruchet")
                .setDescription("Hello, my name is Maxime Caruchet and I am a french student in engineering school. I like web and software development, and also discovering new framework. I'm really enjoying coding in Java, Android and I try new language when I have the time (next is C++). You can check my twitter and linkedIn account for more info!")
                .setSocialNetworkLink(aboutYearMap);

        mListAboutModel.add(mAboutModelBuilder.build());


        // FIXME DATA 6
        aboutYearMap = new HashMap<>();
        mAboutModelBuilder = new AboutModel.Builder();

        aboutYearMap.put("2014", "http://youcode.io/#/home");
        aboutYearMap.put("2015", "http://youcode.io/#/home");

        mAboutModelBuilder
                .setName("Florian Barreau")
                .setDescription("Hi! My name is Florian Barreau, and I'm a French student too. In same cursus like Pierre and Alexis.I like coding for the web. It is really awesome to inovate and learn new technologies like AngularJS or Polymer. I'm web designer for my extra-activity and I like it. I designed this web app. Checkout my twitter and my website for more info!")
                .setSocialNetworkLink(aboutYearMap);

        mListAboutModel.add(mAboutModelBuilder.build());
    }
}
