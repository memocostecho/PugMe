package guillermo.com.pugme.model.retrofit.service;

import guillermo.com.pugme.model.PugsModel;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class PugsService {

    public static final String BASE_URL = "http://pugme.herokuapp.com/";

    public interface PugsServiceAPI {

        @GET("/bomb")
        Observable<PugsModel> fetchImagesUrls(@Query("count") Integer count);

    }

}
