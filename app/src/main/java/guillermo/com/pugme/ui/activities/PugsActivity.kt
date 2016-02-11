package guillermo.com.pugme.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import guillermo.com.pugme.R
import guillermo.com.pugme.ui.fragments.PugsGridFragment
import kotlinx.android.synthetic.main.toolbar.*

class PugsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pugs)
        ButterKnife.bind(this)
        toolbar?.title = ""
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction().add(R.id.pugs_fragment_container, PugsGridFragment()).commit()

    }


}
