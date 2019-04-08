package development.dreamcatcher.pulselivelight.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import development.dreamcatcher.babylonlight.R
import development.dreamcatcher.babylonlight.viewmodels.DetailedViewModel


class DetailedViewFragment : Fragment() {

    private lateinit var viewModel: DetailedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(DetailedViewModel::class.java)
        viewModel.fragment = this

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detailed_view, container, false)

        // Fetch detailed data from the Back-end
        //val itemId = this.arguments?.getInt("itemId")
        //viewModel.getDetailedData(itemId!!)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /*btn_cross.setOnClickListener{
           activity?.onBackPressed()
        }*/
    }

    /*fun setFetchedData(item: ItemDetailed?) {
        textView_item_id.text = item?.id.toString()
        textView_item_title.text = item?.title
        textView_item_subtitle.text = item?.subtitle
        textView_item_body.text = item?.body
        textView_item_date.text = item?.date
    }

    fun dataFetchedProperly() {
        progressBar.visibility = View.GONE
    }

    fun dataFetcheNetworkError() {
        progressBar.visibility = View.GONE
        Toast.makeText(context, R.string.data_couldnt_be_fetched_network, Toast.LENGTH_LONG).show()
    }

    fun dataFetchServerError() {
        progressBar.visibility = View.GONE
        Toast.makeText(context, R.string.data_couldnt_be_fetched_server, Toast.LENGTH_LONG).show()
    }*/
}