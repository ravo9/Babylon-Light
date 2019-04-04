package development.dreamcatcher.babylonlight.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import development.dreamcatcher.babylonlight.activities.GeneralViewActivity
import development.dreamcatcher.babylonlight.apiservice.ApiUtils
import development.dreamcatcher.babylonlight.data.pojo.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class GeneralViewModel : ViewModel() {

    var activity: GeneralViewActivity? = null
    var allPosts: MutableLiveData<List<Post>> = MutableLiveData()

    init {
        ApiUtils.initializeAPIService()
    }

    fun fetchPosts() {

        ApiUtils.getPosts().enqueue(object: Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                if (response!!.isSuccessful) {
                    allPosts.value = LinkedList(response.body())
                    if (allPosts.value != null) {
                        activity?.dataFetchedProperly()
                        activity?.loadFetchedPosts(allPosts.value!!)
                        Log.d("Connection state:", "Connection established")
                    }
                } else {
                    activity?.dataFetchServerError()
                    Log.e("Exception01:", response.message())
                }
            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                activity?.dataFetcheNetworkError()
                Log.e("Exception02:", t?.message)
            }
        })
    }
}