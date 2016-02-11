package guillermo.com.pugme.ui.util

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by guillermo.rosales on 21/01/16.
 */
class HackyViewPager : ViewPager {


    var isLocked: Boolean = false

    constructor(context: Context) : super(context) {
        isLocked = false
    }


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        isLocked = false
    }


    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        if (!isLocked) {
            try {
                return super.onInterceptTouchEvent(ev)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                return false
            }

        }
        return false
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        return !isLocked && super.onTouchEvent(event)
    }

    fun toggleLock() {
        isLocked = !isLocked
    }

}