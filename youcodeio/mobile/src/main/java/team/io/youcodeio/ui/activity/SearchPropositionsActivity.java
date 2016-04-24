package team.io.youcodeio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.mobsandgeeks.saripaar.annotation.Length;

import butterknife.Bind;
import butterknife.OnClick;
import team.io.youcodeio.R;

/**
 * Created by steven_watremez on 23/04/16.
 *
 */
public class SearchPropositionsActivity extends AbsActivity {

    /*
     *****************************************************************
     * UI
     ***************************************************************
     */
    @Length(min = 1, messageResId = R.string.search_field_invalid)
    @Bind(R.id.search_edit_text)
    EditText mSearchEditText;

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
        SearchResultActivity.start(this, mSearchEditText.getText().toString());
    }

    @OnClick(R.id.search_first_button)
    public void onClickSubmitFirstButton() {
        SearchResultActivity.start(this, getString(R.string.search_proposition_go));
    }

    @OnClick(R.id.search_second_button)
    public void onClickSubmitSecondButton() {
        SearchResultActivity.start(this, getString(R.string.search_proposition_android));
    }

    @OnClick(R.id.search_third_button)
    public void onClickSubmitThirdButton() {
        SearchResultActivity.start(this, getString(R.string.search_proposition_angular2));
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
