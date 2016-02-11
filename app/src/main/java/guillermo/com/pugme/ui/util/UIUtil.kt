package guillermo.com.pugme.ui.util

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar

/**
 * Created by guillermo.rosales on 21/01/16.
 */
object UIUtil {

    fun showSnackMessage(coordinatorLayout: CoordinatorLayout?, message: String) {

        Snackbar.make(coordinatorLayout!!, message, Snackbar.LENGTH_LONG).show()


    }

}
