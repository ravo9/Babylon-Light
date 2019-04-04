package development.dreamcatcher.babylonlight.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import development.dreamcatcher.babylonlight.R
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.viewmodels.GeneralViewModel
import development.dreamcatcher.pulselivelight.adapters.ListAdapter
import kotlinx.android.synthetic.main.general_view.*

class GeneralViewActivity : AppCompatActivity() {

    private lateinit var viewModel: GeneralViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.general_view)

        // Initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(GeneralViewModel::class.java)
        viewModel.activity = this

        // Fetch posts from the API
        viewModel.fetchPosts()
    }

    fun loadFetchedPosts(posts: List<Post>) {
        recyclerView_posts.adapter = ListAdapter(posts, this, this)
        recyclerView_posts.layoutManager = LinearLayoutManager(this)
    }

    fun dataFetchedProperly() {
        //progressBar.visibility = View.GONE
        textView_loading.visibility = View.GONE
        Toast.makeText(this, R.string.all_posts_have_been_loaded, Toast.LENGTH_LONG).show()
    }

    fun dataFetcheNetworkError() {
        //progressBar.visibility = View.GONE
        Toast.makeText(this, R.string.data_couldnt_be_fetched_network, Toast.LENGTH_LONG).show()
    }

    fun dataFetchServerError() {
        //progressBar.visibility = View.GONE
        Toast.makeText(this, R.string.data_couldnt_be_fetched_server, Toast.LENGTH_LONG).show()
    }
}
