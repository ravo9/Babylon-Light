package development.dreamcatcher.pulselivelight.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import development.dreamcatcher.babylonlight.R
import development.dreamcatcher.babylonlight.activities.GeneralViewActivity
import development.dreamcatcher.babylonlight.data.pojo.Post
import kotlinx.android.synthetic.main.posts_list_row.view.*


class ListAdapter(private val items : List<Post>, private val context: Context, private val activity: Activity)
    : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.posts_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Prepare fetched data
        val id = "ID:" + items[position].id.toString()
        val userId = "UserId:" + items[position].userId.toString()
        val title = items[position].title

        // Set data within the holder
        holder.id.text = id
        holder.userId.text = userId
        holder.title.text = title

        // Set animation
        val animation = AnimationUtils.loadAnimation(context, R.anim.recycler_view_single_row_animation)
        holder.container?.startAnimation(animation)

        // Set onClickListener
        holder.itemView.setOnClickListener{
            //val itemId = items[position].id
            (activity as GeneralViewActivity).displayDetailedView(0)
        }
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val container = view.row_container
        val id = view.textView_id
        val userId = view.textView_user
        val title = view.textView_title
    }
}

