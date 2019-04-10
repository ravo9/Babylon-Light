package development.dreamcatcher.babylonlight

import development.dreamcatcher.babylonlight.data.repositories.DataRepository
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.data.pojo.User
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class DataRepositoryUnitTest {

    private val fakePost01 = Post(0, 0, "Title", "Words, words, words...")
    private val fakeUser01 = User(0, "John Smith", "johnSmith", "johnsmith@email.com", null, null)

    @Before
    fun initializeDataRepository() {

        // Initialize Data Repository as a Singleton
        DataRepository.initializeDataRepository()

        // Initialize and cache fake data
        val fakePosts = List(1){ fakePost01 }
        val fakeUsers = List(1){ fakeUser01 }

        DataRepository.allPosts.postValue(fakePosts)
        DataRepository.allUsers.postValue(fakeUsers)

    }

    @Test
    fun postCachedCorrectly() {
        val storedPost01 = DataRepository.getPostById(0)
        assertEquals(fakePost01, storedPost01)
    }

    /*@Test
    fun userCachedCorrectly(lifecycle: Lifecycle, observer: (List<User>) -> Unit) {
        DataRepository.allUsers.observe({ lifecycle }) { users ->
            // We have to be sure that data has been already settled (it's performed from the background thread here).
            val storedUser01 = DataRepository.getUserById(0)
            assertEquals(fakeUser01, storedUser01)
        }
    }*/

    /*@Test
    fun userCachedCorrectly() {
        val storedUser01 = DataRepository.getUserById(0)
        assertEquals(fakeUser01, storedUser01)
    }*/
}
