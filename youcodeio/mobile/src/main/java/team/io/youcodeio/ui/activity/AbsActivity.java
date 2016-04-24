package team.io.youcodeio.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.f2prateek.dart.Dart;

import butterknife.Bind;
import butterknife.ButterKnife;
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

        // Get the ActionBar here to configure the way it behaves.
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //ab.setHomeAsUpIndicator(R.drawable.ic_menu); // set a custom icon for the default home button
            actionBar.setDisplayShowHomeEnabled(true); // show or hide the default home button
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title)
        }
        mToolbarTextView.setText(setToolbarTitle());
        mToolbarTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
}
