package guillermo.com.pugme.callbacks

import java.util.*

/**
 * Created by guillermo.rosales on 21/01/16.
 */
interface FetchPugsUrlsCallBack {

    fun onPugsUrlsFetched(urls: ArrayList<String>?)

    fun onReportsFetchFailed(message: String)
}
