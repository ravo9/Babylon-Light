package development.dreamcatcher.babylonlight.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import development.dreamcatcher.babylonlight.R
import development.dreamcatcher.babylonlight.data.DataRepository
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.viewmodels.GeneralViewModel
import development.dreamcatcher.pulselivelight.adapters.ListAdapter
import development.dreamcatcher.pulselivelight.fragments.DetailedViewFragment
import kotlinx.android.synthetic.main.general_view.*

class GeneralViewActivity : AppCompatActivity() {

    private lateinit var viewModel: GeneralViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.general_view)

        // Initialize ViewModel, which also fetches data from the API
        viewModel = ViewModelProviders.of(this).get(GeneralViewModel::class.java)
        viewModel.activity = this

        // Fetch Posts from Data Repository
        loadFetchedPosts()

    }

    private fun loadFetchedPosts() {
        DataRepository.allPosts.observe(this, Observer<List<Post>> { posts ->
            recyclerView_posts.adapter = ListAdapter(posts, this, this)
            recyclerView_posts.layoutManager = LinearLayoutManager(this)
        })
    }

    fun displayDetailedView(id: Int) {

        val fragment = DetailedViewFragment()
        val bundle = Bundle()
        bundle.putInt("itemId", id)
        fragment.arguments = bundle

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit()
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
