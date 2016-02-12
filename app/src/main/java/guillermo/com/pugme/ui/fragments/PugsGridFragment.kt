package guillermo.com.pugme.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import guillermo.com.pugme.R
import guillermo.com.pugme.presenters.PugsPresenter
import guillermo.com.pugme.ui.adapters.PugsAdapter
import guillermo.com.pugme.ui.util.EndlessRecyclerOnScrollListener
import guillermo.com.pugme.ui.viewModel.PugsViewModel
import kotlinx.android.synthetic.main.fragment_pugs.*
import java.util.*

/**
 * Created by guillermo.rosales on 21/01/16.
 */
class PugsGridFragment : Fragment(), PugsViewModel {

    private var gridLayoutManager: GridLayoutManager? = null
    private var adapter: PugsAdapter? = null
    private val imagesUrls = ArrayList<String>()

    private var presenter: PugsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PugsPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_pugs, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PugsAdapter(activity as AppCompatActivity, pugs_coordinator)
        gridLayoutManager = GridLayoutManager(activity, 4)
        pugs_recycler?.layoutManager = gridLayoutManager
        pugs_recycler?.adapter = adapter
        pugs_recycler?.addOnScrollListener(object : EndlessRecyclerOnScrollListener(gridLayoutManager as GridLayoutManager) {
            override fun onLoadMore(current_page: Int) {
                presenter!!.fetchImagesUrls()

            }
        })
        presenter!!.start()

    }

    override fun setImagesUrls(urls: ArrayList<String>) {
        imagesUrls.addAll(urls)
        adapter!!.setPugsImagesUrls(imagesUrls)
        adapter!!.notifyDataSetChanged()
    }

}
