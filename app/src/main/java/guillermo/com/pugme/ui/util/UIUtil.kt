package guillermo.com.pugme.ui.util

import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

/**
 * Created by guillermo.rosales on 21/01/16.
 */


fun AppCompatActivity.showSnackMessage(coordinatorLayout: CoordinatorLayout?, message: String) {
    Snackbar.make(coordinatorLayout!!, message, Snackbar.LENGTH_LONG).show()
}


