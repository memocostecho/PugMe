package guillermo.com.pugme.interactors;

import guillermo.com.pugme.callbacks.FetchPugsUrlsCallBack;
import guillermo.com.pugme.model.PugsModel;
import guillermo.com.pugme.model.retrofit.service.PugsService;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class PugsInteractorImpl implements PugsInteractor {

    private static int LIMIT = 50;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(PugsService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory
                    (RxJavaCallAdapterFactory.create()).build();
    private PugsService.PugsServiceAPI service = retrofit.create(PugsService.PugsServiceAPI.class);

    @Override
    public void fetchPugsUrls(final FetchPugsUrlsCallBack callBack) {

        service.fetchImagesUrls(LIMIT).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                new Action1<PugsModel>() {
                    @Override
                    public void call(PugsModel sfDistrictsModels) {
                        callBack.onPugsUrlsFetched(sfDistrictsModels.getPugs());
                    }
                });

    }
}
