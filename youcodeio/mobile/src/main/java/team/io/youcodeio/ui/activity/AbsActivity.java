package team.io.youcodeio.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.f2prateek.dart.Dart;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import team.io.youcodeio.R;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public abstract class AbsActivity extends AppCompatActivity {

    /*
     *****************************************************************
     * UI
     ***************************************************************
     */
    protected Activity mParent = this;

    @Bind(R.id.toolbar)
    Toolbar mCustomToolbar;

    @Bind(R.id.toolbar_title)
    TextView mToolbarTextView;

    /*
     *****************************************************************
     * LIFE CYCLE
     ***************************************************************
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        ButterKnife.bind(this);
        Dart.inject(this);

        setSupportActionBar(mCustomToolbar);

        mToolbarTextView.setText(setToolbarTitle());
        mToolbarTextView.setVisibility(View.VISIBLE);
    }

    /*
     *****************************************************************
     * ABSTRACT METHODS
     ***************************************************************
     */
    protected abstract int setLayout();

    protected abstract String setToolbarTitle();

    /*
     *****************************************************************
     * USER INTERACTIONS METHODS
     ***************************************************************
     */
    @OnClick(R.id.toolbar_logo)
    public void onClickToolbarMenu() {
        finish();
    }

}
