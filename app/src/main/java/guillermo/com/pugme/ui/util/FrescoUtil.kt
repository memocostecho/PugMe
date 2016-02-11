package guillermo.com.pugme.ui.util

import android.net.Uri

import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.AbstractDraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder

/**
 * Created by guillermo.rosales on 21/01/16.
 */
object FrescoUtil {

    fun fillDrawee(url: String, draweeView: SimpleDraweeView?, width: Int, height: Int) {

        val request1 = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url)).setResizeOptions(ResizeOptions(width, height)).build()
        val controller1 = Fresco.newDraweeControllerBuilder().setOldController(draweeView?.controller).setImageRequest(request1).build()
        draweeView?.controller = controller1

    }

    fun fillDrawee(url: Uri, draweeView: SimpleDraweeView?, width: Int, height: Int) {

        val request1 = ImageRequestBuilder.newBuilderWithSource(url).setResizeOptions(ResizeOptions(width, height)).build()
        val controller1 = Fresco.newDraweeControllerBuilder().setOldController(draweeView?.controller).setImageRequest(request1).build()
        draweeView?.controller = controller1

    }


}
