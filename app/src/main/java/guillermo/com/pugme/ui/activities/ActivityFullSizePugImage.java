package guillermo.com.pugme.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import guillermo.com.pugme.R;
import guillermo.com.pugme.ui.adapters.PhotosPagerAdapter;
import guillermo.com.pugme.ui.util.HackyViewPager;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class ActivityFullSizePugImage extends AppCompatActivity {

    @Bind(R.id.photos_view_pager)
    HackyViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private List urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_size_image);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent() != null) {
            urls = (List) getIntent().getSerializableExtra("photos");
            viewPager.setAdapter(new PhotosPagerAdapter(urls, this));
            viewPager.setCurrentItem(getIntent().getIntExtra("position", 0), true);

        }


    }


}
