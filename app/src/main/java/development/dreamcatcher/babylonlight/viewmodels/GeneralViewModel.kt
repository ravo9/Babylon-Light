package development.dreamcatcher.babylonlight.viewmodels

import androidx.lifecycle.ViewModel
import development.dreamcatcher.babylonlight.activities.GeneralViewActivity
import development.dreamcatcher.babylonlight.apiservice.ApiUtils
import development.dreamcatcher.babylonlight.data.repositories.DataRepository


class GeneralViewModel : ViewModel() {

    var activity: GeneralViewActivity? = null

    init {
        ApiUtils.initializeAPIService()
        DataRepository.initializeDataRepository()
        DataRepository.fetchDataFromApi()
    }
}