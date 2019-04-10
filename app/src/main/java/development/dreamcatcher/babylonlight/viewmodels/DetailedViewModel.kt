package development.dreamcatcher.babylonlight.viewmodels

import androidx.lifecycle.ViewModel
import development.dreamcatcher.babylonlight.apiservice.ApiUtils
import development.dreamcatcher.babylonlight.data.repositories.DataRepository
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.data.pojo.User
import development.dreamcatcher.babylonlight.fragments.DetailedViewFragment


class DetailedViewModel : ViewModel() {

    var fragment: DetailedViewFragment? = null

    init {
        ApiUtils.initializeAPIService()
        DataRepository.initializeDataRepository()
    }

    fun getDetailedData(postId: Int) {

        val post: Post?
        val user: User?
        val commentsAmount: Int?

        post = DataRepository.getPostById(postId)
        val userId = post?.userId
        user = DataRepository.getUserById(userId)
        commentsAmount = DataRepository.getCommentsAmount(postId)

        (fragment as DetailedViewFragment).setFetchedData(post, user, commentsAmount)
    }
}