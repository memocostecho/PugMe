package guillermo.com.pugme.ui.util;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class UIUtil {

    public static void showSnackMessage(CoordinatorLayout coordinatorLayout,String message){

        Snackbar.make(coordinatorLayout,message,Snackbar.LENGTH_LONG).show();


    }

}
