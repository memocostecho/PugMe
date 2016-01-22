package guillermo.com.pugme.ui.adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

import guillermo.com.pugme.ui.activities.ActivityFullSizePugImage;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class PhotosPagerAdapter extends PagerAdapter {

    private final List urls;
    private ActivityFullSizePugImage context;


    public PhotosPagerAdapter(List urls, ActivityFullSizePugImage context) {
        this.urls = urls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return urls.size();
    }


    @Override
    public View instantiateItem(final ViewGroup container, int position) {

        final PhotoView photoView = new PhotoView(container.getContext());
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        showFullImage(photoView, (String) urls.get(position));

        return photoView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private void showFullImage(final PhotoView photoView, String url) {

        ImagePipeline imagePipeline = Fresco.getImagePipeline();

        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(url))
                .setRequestPriority(Priority.HIGH)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .build();

        DataSource<CloseableReference<CloseableImage>> dataSource =
                imagePipeline.fetchDecodedImage(imageRequest, context);

        dataSource.subscribe(new BaseBitmapDataSubscriber() {
            @Override
            protected void onNewResultImpl(final Bitmap bitmap) {
                photoView.post(new Runnable() {
                    @Override
                    public void run() {
                        photoView.setImageDrawable(new BitmapDrawable(context.getResources(), bitmap));
                    }
                });

            }

            @Override
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {

            }
        }, CallerThreadExecutor.getInstance());
    }
}