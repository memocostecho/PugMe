package guillermo.com.pugme.ui.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.facebook.drawee.view.SimpleDraweeView
import guillermo.com.pugme.R
import guillermo.com.pugme.ui.activities.ActivityFullSizePugImage
import guillermo.com.pugme.ui.util.FrescoUtil
import guillermo.com.pugme.ui.util.UIUtil
import java.io.Serializable
import java.util.*


/**
 * Created by guillermo.rosales on 21/01/16.
 */
class PugsAdapter(private val context: AppCompatActivity, private val coordinatorLayout: CoordinatorLayout?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var pugsImagesUrls = ArrayList<String>()
    fun setPugsImagesUrls(pugsImagesUrls: ArrayList<String>) {
        this.pugsImagesUrls = pugsImagesUrls
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.pug_image_item, parent, false)

        return PugImageViewHolder(view)
    }

    override fun onBindViewHolder(geneticHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = geneticHolder as PugImageViewHolder
        FrescoUtil.fillDrawee(pugsImagesUrls[position], holder.pugImage, 150, 150)
        holder.pugImage?.setOnLongClickListener {
            val clipboard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("url", pugsImagesUrls[position])
            clipboard.primaryClip = clip
            UIUtil.showSnackMessage(coordinatorLayout, context?.resources!!.getString(R.string.url_copied_message))
            true
        }
        holder.pugImage.setOnClickListener {
            val intent = Intent(context!!, ActivityFullSizePugImage::class.java)
            intent.putExtra("photos", pugsImagesUrls as Serializable)
            intent.putExtra("position", position)
            context?.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return pugsImagesUrls.size
    }


    class PugImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var pugImage : SimpleDraweeView = view.findViewById(R.id.pug_image) as SimpleDraweeView
        init {
            ButterKnife.bind(this, view)
        }
    }


}
