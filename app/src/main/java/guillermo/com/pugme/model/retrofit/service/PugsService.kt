package guillermo.com.pugme.model.retrofit.service

import guillermo.com.pugme.model.PugsModel
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * Created by guillermo.rosales on 21/01/16.
 */
class PugsService {

    companion object {
        val BASE_URL = "http://pugme.herokuapp.com/"
    }

    interface PugsServiceAPI {

        @GET("/bomb")
        fun fetchImagesUrls(@Query("count") count: Int?): Observable<PugsModel>

    }

}


