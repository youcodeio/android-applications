package team.io.youcodeio.ui.activity.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

import butterknife.Bind;
import butterknife.ButterKnife;
import team.io.youcodeio.R;
import team.io.youcodeio.model.about.About;

/**
 * Created by steven_watremez on 24/04/16.
 *
 */
public class TeamDetailActivity extends AppCompatActivity {

    final private static String BUNDLE_ABOUT_OBJECT = "BUNDLE_ABOUT_OBJECT";

    @Bind(R.id.about_team_detail_title)
    TextView mTitleTextView;

    @Bind(R.id.about_team_detail_description_text_view)
    TextView mDescriptionTextView;

    @InjectExtra(BUNDLE_ABOUT_OBJECT)
    About mAboutItem;

    public static void start(Context context, @NonNull final About aboutItem) {
        Intent starter = new Intent(context, TeamDetailActivity.class);
        starter.putExtra(BUNDLE_ABOUT_OBJECT, aboutItem);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        Dart.inject(this);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        Bundle bundle = getIntent().getExtras(); // getArguments() for a Fragment
        mAboutItem = Dart.get(bundle, BUNDLE_ABOUT_OBJECT); // User implements Parcelable
        mTitleTextView.setText(mAboutItem.name);
        mDescriptionTextView.setText(String.format("%s - %s", mAboutItem.skills, mAboutItem.description));
    }
}
