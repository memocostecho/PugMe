package guillermo.com.pugme.presenters;

import java.util.List;

import guillermo.com.pugme.callbacks.FetchPugsUrlsCallBack;
import guillermo.com.pugme.interactors.PugsInteractor;
import guillermo.com.pugme.interactors.PugsInteractorImpl;
import guillermo.com.pugme.ui.viewModel.PugsViewModel;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class PugsPresenter implements ActivityFragmentPresenter, FetchPugsUrlsCallBack {

    private PugsViewModel pugsView;
    private PugsInteractor interactor;

    public PugsPresenter(PugsViewModel pugsView) {
        this.pugsView = pugsView;
        interactor = new PugsInteractorImpl();

    }

    @Override
    public void start() {

        interactor.fetchPugsUrls(this);

    }

    public void fetchImagesUrls() {

        interactor.fetchPugsUrls(this);

    }


    @Override
    public void onPugsUrlsFetched(List<String> urls) {
        pugsView.setImagesUrls(urls);
    }

    @Override
    public void onReportsFetchFailed(String message) {

    }
}
