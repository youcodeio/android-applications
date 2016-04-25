package team.io.youcodeio.ui.adapter.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import team.io.youcodeio.R;
import team.io.youcodeio.model.search.Search;

/**
 * Created by steven_watremez on 25/04/16.
 *
 */
public class VideoDetailsActivity extends AppCompatActivity {

    /*****************************************************************
     * STATIC
     ****************************************************************/
    final private static String BUNDLE_VIDEO = "BUNDLE_VIDEO";

    /*****************************************************************
     * DATA
     ****************************************************************/
    @InjectExtra(BUNDLE_VIDEO)
    Search mVideo;

    /*****************************************************************
     * UI
     ****************************************************************/
    @Bind(R.id.details_video_title)
    TextView mVideoTitleTextView;

    @Bind(R.id.details_video_description)
    TextView mVideoDescriptionTextView;

    @Bind(R.id.details_video_channel_title)
    TextView mChannelTitleTextView;

    @Bind(R.id.details_video_channel_description)
    TextView mChannelDescriptionTextView;

    /*****************************************************************
     * STARTER
     ****************************************************************/
    public static void start(@NonNull final Context context, @NonNull final Search video) {
        Intent starter = new Intent(context, VideoDetailsActivity.class);
        starter.putExtra(BUNDLE_VIDEO, video);
        context.startActivity(starter);
    }

    /*****************************************************************
     * LIFE CYCLE
     ****************************************************************/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        Dart.inject(this);
        ButterKnife.bind(this);
        initUI();
    }

    @OnClick(R.id.details_close_image_button)
    public void onClickClose() {
        finish();
    }

    /*****************************************************************
     * PRIVATE METHODS
     ****************************************************************/
    private void initUI() {
        Bundle bundle = getIntent().getExtras(); // getArguments() for a Fragment
        mVideo = Dart.get(bundle, BUNDLE_VIDEO); // User implements Parcelable

        mVideoTitleTextView.setText(mVideo.snippet.title);
        mVideoDescriptionTextView.setText(mVideo.snippet.description);
        mChannelTitleTextView.setText(mVideo.snippet.channelTitle);
    }
}
