package development.dreamcatcher.babylonlight.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import development.dreamcatcher.babylonlight.R
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.data.pojo.User
import development.dreamcatcher.babylonlight.viewmodels.DetailedViewModel
import kotlinx.android.synthetic.main.fragment_detailed_view.*


class DetailedViewFragment : Fragment() {

    private lateinit var viewModel: DetailedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(DetailedViewModel::class.java)
        viewModel.fragment = this

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Fetch detailed data from Data Repository
        val postId = this.arguments?.getInt("postId")
        if (postId != null) viewModel.getDetailedData(postId)

        btn_cross.setOnClickListener{
           activity?.onBackPressed()
        }
    }

    fun setFetchedData(post: Post?, user: User?, commentsAmount: Int) {
        textView_post_title.text = post?.title
        textView_post_body.text = post?.body
        textView_author_name.text = user?.name
        val commentsAmountText = "Comments: " + commentsAmount.toString()
        textView_comments_amount.text = commentsAmountText

        // Load avatar
        Picasso.with(context).load(user?.avatarUrl).into(avatar)

        // Switch off the progress bar (loading circle)
        progressBar.visibility = View.GONE
    }
}