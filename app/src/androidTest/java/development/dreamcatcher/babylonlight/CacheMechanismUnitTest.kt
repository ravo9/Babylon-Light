package development.dreamcatcher.babylonlight

import development.dreamcatcher.babylonlight.data.pojo.Comment
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.data.pojo.User
import development.dreamcatcher.babylonlight.data.repositories.DataRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class CacheMechanismUnitTest {

    // The aim of this test is to check whether the caching mechanism (based on LiveData)
    // accepts and stores given data properly.

    private val fakePost = Post(0, 0, "Title", "Words, words, words...")
    private var fakeUser = User(0, "John Smith", "johnSmith", "johnsmith@email.com", "000-444-333", "mywebsite.com")
    private var fakeComment = Comment(0, 0, "Johnny Bravo", "johnnybravo@mail.com", "Words, words, words...")

    @Before
    fun initializeDataRepository() {

        // Initialize Data Repository (implemented as a Singleton)
        DataRepository.initializeDataRepository()

        // Initialize and cache fake data
        val fakePosts = List(1){ fakePost }
        val fakeUsers = List(1){ fakeUser }
        val fakeComment = List(1){ fakeComment }

        DataRepository.allPosts.postValue(fakePosts)
        DataRepository.allUsers.postValue(fakeUsers)
        DataRepository.allComments.postValue(fakeComment)

        Thread.sleep(1000)
    }

    @Test
    fun postCachedCorrectly() {
        val storedPost = DataRepository.getPostById(0)
        assertEquals(fakePost, storedPost)
    }

    @Test
    fun userCachedCorrectly() {
        val storedUser = DataRepository.getUserById(0)
        assertEquals(fakeUser, storedUser)
    }

    @Test
    fun commentCachedCorrectly() {
        val storedCommentsAmount = DataRepository.getCommentsAmount(0)
        assertEquals(1, storedCommentsAmount)
    }
}
