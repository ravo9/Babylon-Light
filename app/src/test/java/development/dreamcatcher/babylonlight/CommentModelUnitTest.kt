package development.dreamcatcher.babylonlight

import development.dreamcatcher.babylonlight.data.pojo.Comment
import org.junit.Assert.assertEquals
import org.junit.Test


class CommentModelUnitTest {

    private var allDataComment = Comment(0, 0, "Johnny Bravo", "johnnybravo@mail.com", "Words, words, words...")
    private var allNecessaryDataComment = Comment(0, 0, "Johnny Bravo", "johnnybravo@mail.com", null)

    @Test
    fun createAllDataComment() {
        val postId = 0
        val id = 0
        val name = "Johnny Bravo"
        val email = "johnnybravo@mail.com"
        val body = "Words, words, words..."

        val newComment = Comment(postId, id, name, email, body)

        assertEquals(newComment, allDataComment)
    }

    @Test
    fun createAllNecessaryDataComment() {
        val postId = 0
        val id = 0
        val name = "Johnny Bravo"
        val email = "johnnybravo@mail.com"
        val body = null

        val newComment = Comment(postId, id, name, email, body)

        assertEquals(newComment, allNecessaryDataComment)
    }
}