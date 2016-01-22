package guillermo.com.pugme.ui.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import guillermo.com.pugme.R;
import guillermo.com.pugme.ui.activities.ActivityFullSizePugImage;
import guillermo.com.pugme.ui.util.FrescoUtil;
import guillermo.com.pugme.ui.util.UIUtil;

/**
 * Created by guillermo.rosales on 21/01/16.
 */
public class PugsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> pugsImagesUrls = new ArrayList<>();
    private AppCompatActivity context;
    private CoordinatorLayout coordinatorLayout;

    public PugsAdapter(AppCompatActivity context, CoordinatorLayout coordinatorLayout) {
        this.context = context;
        this.coordinatorLayout = coordinatorLayout;
    }

    public void setPugsImagesUrls(ArrayList pugsImagesUrls) {
        this.pugsImagesUrls = pugsImagesUrls;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.pug_image_item, parent, false);

        return new PugImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder geneticHolder, final int position) {
        PugImageViewHolder holder = (PugImageViewHolder) geneticHolder;
        FrescoUtil.fillDrawee(pugsImagesUrls.get(position), holder.pugImage, 150, 150);
        holder.pugImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("url", pugsImagesUrls.get(position));
                clipboard.setPrimaryClip(clip);
                UIUtil.showSnackMessage(coordinatorLayout,context.getResources().getString(R.string.url_copied_message));
                return true;
            }
        });

        holder.pugImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ActivityFullSizePugImage.class);
                intent.putExtra("photos", (Serializable) pugsImagesUrls);
                intent.putExtra("position", position);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pugsImagesUrls.size();
    }


    public static class PugImageViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.pug_image)
        SimpleDraweeView pugImage;


        public PugImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
