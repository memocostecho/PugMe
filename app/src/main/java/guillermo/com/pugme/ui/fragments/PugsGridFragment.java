package guillermo.com.pugme.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import guillermo.com.pugme.R;
import guillermo.com.pugme.presenters.PugsPresenter;
import guillermo.com.pugme.ui.adapters.PugsAdapter;
import guillermo.com.pugme.ui.util.EndlessRecyclerOnScrollListener;
import guillermo.com.pugme.ui.viewModel.PugsViewModel;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class PugsGridFragment extends Fragment implements PugsViewModel {

    @Bind(R.id.pugs_recycler)
    RecyclerView recyclerView;
    @Bind(R.id.pugs_coordinator)
    CoordinatorLayout coordinatorLayout;



    private GridLayoutManager gridLayoutManager;
    private PugsAdapter adapter;
    private ArrayList<String> imagesUrls = new ArrayList<>();

    private PugsPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PugsPresenter(this);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pugs, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = new PugsAdapter((AppCompatActivity) getActivity(),coordinatorLayout);
        gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener
                (gridLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                presenter.fetchImagesUrls();

            }
        });

        presenter.start();


    }

    @Override
    public void setImagesUrls(List<String> urls) {
        imagesUrls.addAll(urls);
        adapter.setPugsImagesUrls(imagesUrls);
        adapter.notifyDataSetChanged();
    }


}
