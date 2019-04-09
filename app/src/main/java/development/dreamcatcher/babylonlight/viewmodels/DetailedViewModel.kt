package development.dreamcatcher.babylonlight.viewmodels

import androidx.lifecycle.ViewModel
import development.dreamcatcher.babylonlight.data.DataRepository
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.data.pojo.User
import development.dreamcatcher.pulselivelight.fragments.DetailedViewFragment


class DetailedViewModel : ViewModel() {

    var fragment: DetailedViewFragment? = null

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