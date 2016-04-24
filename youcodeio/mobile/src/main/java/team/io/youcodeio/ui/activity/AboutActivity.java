package team.io.youcodeio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import team.io.youcodeio.R;
import team.io.youcodeio.model.about.About;
import team.io.youcodeio.model.about.SocialNetwork;
import team.io.youcodeio.ui.adapter.about.AboutRecyclerViewAdapter;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public class AboutActivity extends AbsActivity {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private About mAbout;
    private List<About> mListAbout;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.about_recycler_view)
    RecyclerView mAboutRecyclerView;

    /*****************************************************************
     * STARTER
     ****************************************************************/
    public static void start(Context context) {
        Intent starter = new Intent(context, AboutActivity.class);
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
        return R.layout.activity_about;
    }

    @Override
    protected String setToolbarTitle() {
        return getString(R.string.drawer_menu_about);
    }


    /*****************************************************************
     * PRIVATE METHOD
     ****************************************************************/

    private void initUI() {

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mAboutRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mAboutRecyclerView.setLayoutManager(mLayoutManager);

        // FIXME : call the About WS to retrieve the data
        createFakeAboutdata();

        mAdapter = new AboutRecyclerViewAdapter(mListAbout);
        mAboutRecyclerView.setAdapter(mAdapter);
    }

    private void createFakeAboutdata() {
        List<SocialNetwork> socialNetworkList = new ArrayList<>();

        // FIXME DATA 1
        mListAbout = new ArrayList<>();

        socialNetworkList.add(new SocialNetwork("2014", "http://youcode.io/#/home"));
        socialNetworkList.add(new SocialNetwork("2015", "http://youcode.io/#/home"));

        mAbout = new About(
                "1",
                "Pierre Zemb",
                "Dev back",
                "Hi! My name is Pierre Zemb, and I'm a French student in a graduate school of engineeringscience called ISEN where I'm currently studying Software Engineering. I'm really enjoying coding in C++, Java or Go and ship them with Docker, but I always end up developping Web apps like this one. Checkout my twitter and my website for more info!",
                socialNetworkList);

        mListAbout.add(mAbout);


        // FIXME DATA 2
        mAbout = new About(
                "2",
                "Alexis Hellouin",
                "Dev web front and back",
                "Hello, my name is Alexis and I am a french student in engineering school. I like web and software development, and also discovering new framework. I'm really enjoying coding in Java, Android and I try new language when I have the time (next is C++). You can check my twitter and linkedIn account for more info!",
                socialNetworkList);

        mListAbout.add(mAbout);


        // FIXME DATA 3
        mAbout = new About(
                "3",
                "Steven Watremez",
                "Dev web and mobile front",
                "Hi! My name is Steven Watremez, and I'm a French student too. In same cursus like Pierre and Alexis.I like coding for the web. It is really awesome to inovate and learn new technologies like AngularJS or Polymer. I'm web designer for my extra-activity and I like it. I designed this web app. Checkout my twitter and my website for more info!",
                socialNetworkList);

        mListAbout.add(mAbout);

        // FIXME DATA 4
        mAbout = new About(
                "4",
                "Mathieu Sallardon",
                "Dev web front",
                "Hi! My name is Mathieu Sallardon, and I'm a French student in a graduate school of engineeringscience called ISEN where I'm currently studying Software Engineering. I'm really enjoying coding in C++, Java or Go and ship them with Docker, but I always end up developping Web apps like this one. Checkout my twitter and my website for more info!",
                socialNetworkList);

        mListAbout.add(mAbout);


        // FIXME DATA 5
        mAbout = new About(
                "5",
                "Maxime Caruchet",
                "Dev back & Devops",
                "Hello, my name is Maxime Caruchet and I am a french student in engineering school. I like web and software development, and also discovering new framework. I'm really enjoying coding in Java, Android and I try new language when I have the time (next is C++). You can check my twitter and linkedIn account for more info!",
                socialNetworkList);

        mListAbout.add(mAbout);

        // FIXME DATA 6
        mAbout = new About(
                "6",
                "Florian Barreau",
                "Dev web front",
                "Hi! My name is Florian Barreau, and I'm a French student too. In same cursus like Pierre and Alexis.I like coding for the web. It is really awesome to inovate and learn new technologies like AngularJS or Polymer. I'm web designer for my extra-activity and I like it. I designed this web app. Checkout my twitter and my website for more info!",
                socialNetworkList);

        mListAbout.add(mAbout);
    }
}
