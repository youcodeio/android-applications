package team.io.youcodeio.helper;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by stevenwatremez on 03/04/16.
 *
 */
public class HandleErrorHelper {

    /*****************************************************************
     * STATIC PROPERTIES
     ****************************************************************/

    /*****************************************************************
     * STATIC METHODS
     ****************************************************************/
    public static void showErrorSnackBar(final View view, final String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(Color.RED);
        snackbar.show();
    }

    public static void showSuccessSnackBar(final View view, final String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(Color.GREEN);
        snackbar.show();
    }

    public static void showNeutralSnackBar(final View view, final String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
    /*****************************************************************
     * PRIVATE METHODS
     ****************************************************************/
}
