package guillermo.com.pugme.application

import android.app.Application

import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by guillermo.rosales on 21/01/16.
 */
class PugsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(applicationContext)
    }
}
