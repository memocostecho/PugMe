package guillermo.com.pugme.ui.util;

import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class FrescoUtil {

    public static void fillDrawee(String url, SimpleDraweeView draweeView, int width, int height) {

        ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setResizeOptions(new ResizeOptions(width, height))
                .build();
        AbstractDraweeController controller1 = Fresco.newDraweeControllerBuilder()
                .setOldController(draweeView.getController())
                .setImageRequest(request1)
                .build();
        draweeView.setController(controller1);

    }

    public static void fillDrawee(Uri url, SimpleDraweeView draweeView, int width, int height) {

        ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(url)
                .setResizeOptions(new ResizeOptions(width, height))
                .build();
        AbstractDraweeController controller1 = Fresco.newDraweeControllerBuilder()
                .setOldController(draweeView.getController())
                .setImageRequest(request1)
                .build();
        draweeView.setController(controller1);

    }


}
