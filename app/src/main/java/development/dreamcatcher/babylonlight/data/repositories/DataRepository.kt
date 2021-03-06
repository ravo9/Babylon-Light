package development.dreamcatcher.babylonlight.data.repositories

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import development.dreamcatcher.babylonlight.apiservice.ApiUtils
import development.dreamcatcher.babylonlight.data.pojo.Comment
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.data.pojo.User
import io.reactivex.schedulers.Schedulers


class DataRepository {

    companion object {

        var dataRepository: DataRepository? = null

        var allPosts: MutableLiveData<List<Post>> = MutableLiveData()
        var allUsers: MutableLiveData<List<User>> = MutableLiveData()
        var allComments: MutableLiveData<List<Comment>> = MutableLiveData()

        val errorFlag: MutableLiveData<Boolean> = MutableLiveData()

        fun initializeDataRepository() {
            if (dataRepository == null)
                dataRepository =
                    DataRepository()
        }

        fun fetchDataFromApi() {
            fetchPosts()
            fetchUsers()
            fetchComments()
        }

        @SuppressLint("CheckResult")
        private fun fetchPosts() {

            ApiUtils.getPosts()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { posts ->
                        allPosts.postValue(posts)
                    },
                    { throwable ->
                        errorFlag.postValue(true)
                        Log.e("Error:", throwable.message)
                    }
                )
        }

        @SuppressLint("CheckResult")
        private fun fetchUsers() {

            ApiUtils.getUsers()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { users ->
                        allUsers.postValue(users)
                    },
                    { throwable ->
                        errorFlag.postValue(true)
                        Log.e("Error:", throwable.message)
                    }
                )
        }

        @SuppressLint("CheckResult")
        private fun fetchComments() {

            ApiUtils.getComments()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { comments ->
                        allComments.postValue(comments)
                    },
                    { throwable ->
                        errorFlag.postValue(true)
                        Log.e("Error:", throwable.message)
                    }
                )
        }

        fun getPostById(id: Int?) : Post? {
            return allPosts.value?.find { post -> post.id == id }
        }

        fun getUserById(id: Int?) : User? {
            return allUsers.value?.find { user -> user.id == id }
        }

        fun getCommentsAmount(postId: Int?) : Int {
            val commentsAmount = allComments.value?.filter { comment -> comment.postId == postId }?.size
            if (commentsAmount == null) return 0
            else return commentsAmount
        }
    }
}