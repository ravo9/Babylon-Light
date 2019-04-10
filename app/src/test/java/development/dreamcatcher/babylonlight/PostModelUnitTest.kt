package development.dreamcatcher.babylonlight

import development.dreamcatcher.babylonlight.data.pojo.Post
import org.junit.Assert.assertEquals
import org.junit.Test


class PostModelUnitTest {

    private var allDataPost = Post(0, 0, "Title", "Words, words, words...")
    private var allNecessaryDataPost = Post(0, 0, "Title", null)

    @Test
    fun createAllDataPost() {
        val userId = 0
        val id = 0
        val title = "Title"
        val body = "Words, words, words..."

        val newPost = Post(userId, id, title, body)

        assertEquals(newPost, allDataPost)
    }

    @Test
    fun createAllNecessaryDataPost() {
        val userId = 0
        val id = 0
        val title = "Title"
        val body = null

        val newPost = Post(userId, id, title, body)

        assertEquals(newPost, allNecessaryDataPost)
    }
}