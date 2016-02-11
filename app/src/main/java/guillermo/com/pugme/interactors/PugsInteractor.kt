package guillermo.com.pugme.interactors

import guillermo.com.pugme.callbacks.FetchPugsUrlsCallBack

/**
 * Created by guillermo.rosales on 21/01/16.
 */
interface PugsInteractor {

    fun fetchPugsUrls(callBack: FetchPugsUrlsCallBack)
}
