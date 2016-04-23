package team.io.youcodeio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import team.io.youcodeio.R;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public class SearchPropositionsActivity extends AbsActivity {

    /*
     *****************************************************************
     * STARTER
     ***************************************************************
     */
    public static void start(Context context) {
        Intent starter = new Intent(context, SearchPropositionsActivity.class);
        context.startActivity(starter);
    }

    /*
     *****************************************************************
     * LIFE CYCLE
     ***************************************************************
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*
     *****************************************************************
     * USER INTERACTIONS METHODS
     ***************************************************************
     */
    @OnClick(R.id.search_submit_button)
    public void onClickSubmit() {
        SearchResultActivity.start(this, "Android");
        finish();
    }

    /*
     *****************************************************************
     * IMPLEMENTS METHODS
     ***************************************************************
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_search_propositions;
    }

    @Override
    protected String setToolbarTitle() {
        return "Search";
    }
}
