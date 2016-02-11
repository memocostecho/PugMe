package guillermo.com.pugme.interactors

import guillermo.com.pugme.callbacks.FetchPugsUrlsCallBack
import guillermo.com.pugme.model.PugsModel
import guillermo.com.pugme.model.retrofit.service.PugsService
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers


/**
 * Created by guillermo.rosales on 21/01/16.
 */
class PugsInteractorImpl : PugsInteractor {
    private val retrofit = Retrofit.Builder().baseUrl(PugsService.BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
    private val service = retrofit.create<PugsService.PugsServiceAPI>(PugsService.PugsServiceAPI::class.java)

    override fun fetchPugsUrls(callBack: FetchPugsUrlsCallBack) {

        service.fetchImagesUrls(LIMIT).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe { sfDistrictsModels -> callBack.onPugsUrlsFetched(sfDistrictsModels.pugs) }

    }

    companion object {

        private val LIMIT = 50
    }
}
