package development.dreamcatcher.babylonlight.viewmodels

import android.content.Context
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import development.dreamcatcher.babylonlight.activities.GeneralViewActivity
import development.dreamcatcher.babylonlight.apiservice.ApiUtils
import development.dreamcatcher.babylonlight.data.DataRepository
import development.dreamcatcher.babylonlight.data.pojo.Post


class GeneralViewModel : ViewModel() {

    var activity: GeneralViewActivity? = null
    //var allPosts: MutableLiveData<List<Post>> = MutableLiveData()

    init {
        ApiUtils.initializeAPIService()
        DataRepository.initializeDataRepository()
        DataRepository.fetchDataFromApi()
    }

    /*fun fetchDataFromApi() {

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
    }*/

}