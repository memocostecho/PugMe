package guillermo.com.pugme.presenters

import guillermo.com.pugme.callbacks.FetchPugsUrlsCallBack
import guillermo.com.pugme.interactors.PugsInteractor
import guillermo.com.pugme.interactors.PugsInteractorImpl
import guillermo.com.pugme.ui.viewModel.PugsViewModel
import java.util.*

/**
 * Created by guillermo.rosales on 21/01/16.
 */
class PugsPresenter(private val pugsView: PugsViewModel) : ActivityFragmentPresenter, FetchPugsUrlsCallBack {
    private val interactor: PugsInteractor

    init {
        interactor = PugsInteractorImpl()

    }

    override fun start() {

        interactor.fetchPugsUrls(this)

    }

    fun fetchImagesUrls() {

        interactor.fetchPugsUrls(this)

    }


    override fun onPugsUrlsFetched(urls: ArrayList<String>?) {
        pugsView.setImagesUrls(urls!!)
    }

    override fun onReportsFetchFailed(message: String) {

    }
}
