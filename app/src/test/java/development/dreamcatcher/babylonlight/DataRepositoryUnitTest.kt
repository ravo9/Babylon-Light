package development.dreamcatcher.babylonlight

import development.dreamcatcher.babylonlight.data.DataRepository
import development.dreamcatcher.babylonlight.data.pojo.Post
import development.dreamcatcher.babylonlight.data.pojo.User
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test


class DataRepositoryUnitTest {

    /*private val fakePost01 = Post(0, 0, "Title", "Words, words, words...")
    private val fakeUser01 = User(0, "John Smith", "johnSmith", "johnsmith@email.com", null, null)

    @Before
    fun initializeDataRepository() {

        // Initialize Data Repository as a Singleton
        DataRepository.initializeDataRepository()

        // Initialize fake data
        val fakePosts = List(1){ fakePost01 }
        val fakeUsers = List(1){ fakeUser01 }

        DataRepository.allPosts.value = fakePosts
        DataRepository.allUsers.postValue(fakeUsers)
    }

    @Test
    fun dataCachedCorrectly() {

        val storedPost01 = DataRepository.getPostById(0)
        val storedUser01 = DataRepository.getUserById(0)

        assertSame(fakePost01, storedPost01)
        assertSame(fakeUser01, storedUser01)
    }*/
}
