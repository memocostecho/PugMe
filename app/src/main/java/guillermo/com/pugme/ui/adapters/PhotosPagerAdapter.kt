package guillermo.com.pugme.ui.adapters

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import com.facebook.common.executors.CallerThreadExecutor
import com.facebook.common.references.CloseableReference
import com.facebook.datasource.DataSource
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.common.Priority
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
import com.facebook.imagepipeline.image.CloseableImage
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import guillermo.com.pugme.ui.activities.ActivityFullSizePugImage
import uk.co.senab.photoview.PhotoView

/**
 * Created by guillermo.rosales on 21/01/16.
 */
class PhotosPagerAdapter(private val urls: List<Any>, private val context: ActivityFullSizePugImage) : PagerAdapter() {

    override fun getCount(): Int {
        return urls.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val photoView = PhotoView(container.context)
        container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        showFullImage(photoView, urls[position] as String)
        return photoView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    private fun showFullImage(photoView: PhotoView, url: String) {
        val imagePipeline = Fresco.getImagePipeline()
        val imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url)).setRequestPriority(Priority.HIGH).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build()
        val dataSource = imagePipeline.fetchDecodedImage(imageRequest, context)
        dataSource.subscribe(object : BaseBitmapDataSubscriber() {
            override fun onNewResultImpl(bitmap: Bitmap?) {
                photoView.post { photoView.setImageDrawable(BitmapDrawable(context.resources, bitmap)) }
            }
            override fun onFailureImpl(dataSource: DataSource<CloseableReference<CloseableImage>>) {
            }
        }, CallerThreadExecutor.getInstance())
    }
}