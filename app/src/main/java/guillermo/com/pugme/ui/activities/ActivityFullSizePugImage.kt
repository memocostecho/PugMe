package guillermo.com.pugme.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import guillermo.com.pugme.R
import guillermo.com.pugme.ui.adapters.PhotosPagerAdapter
import kotlinx.android.synthetic.main.activity_full_size_image.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by guillermo.rosales on 21/01/16.
 */
class ActivityFullSizePugImage : AppCompatActivity() {

    private var urls: List<Any>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_size_image)
        ButterKnife.bind(this)
        toolbar?.title = ""
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    override fun onResume() {
        super.onResume()

        if (intent != null) {
            urls = intent.getSerializableExtra("photos") as List<Any>
            photos_view_pager?.adapter = PhotosPagerAdapter(urls as List<Any>, this)
            photos_view_pager?.setCurrentItem(intent.getIntExtra("position", 0), true)
        }
    }


}
