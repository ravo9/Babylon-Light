package development.dreamcatcher.babylonlight.viewmodels

import androidx.lifecycle.ViewModel
import development.dreamcatcher.pulselivelight.fragments.DetailedViewFragment


class DetailedViewModel : ViewModel() {

    var fragment: DetailedViewFragment? = null

    fun getDetailedData(id: Int) {

        /*ApiUtils.getDetailedData(id).enqueue(object: Callback<ResponseMessageDetailedItem> {

            override fun onResponse(call: Call<ResponseMessageDetailedItem>?, response: Response<ResponseMessageDetailedItem>?) {
                if (response!!.isSuccessful) {
                    fragment?.setFetchedData(response.body()?.item)
                    fragment?.dataFetchedProperly()
                    Log.d("Connection state:", "Connection established")
                } else {
                    fragment?.dataFetchServerError()
                    Log.e("Exception01:", response.message())
                }
            }

            override fun onFailure(call: Call<ResponseMessageDetailedItem>?, t: Throwable?) {
                fragment?.dataFetcheNetworkError()
                Log.e("Exception02:", t?.message)
            }
        })*/
    }
}