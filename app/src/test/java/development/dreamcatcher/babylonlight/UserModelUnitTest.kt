package development.dreamcatcher.babylonlight

import development.dreamcatcher.babylonlight.data.pojo.User
import org.junit.Assert.assertEquals
import org.junit.Test


class UserModelUnitTest {

    private var allDataUser = User(0, "John Smith", "johnSmith", "johnsmith@email.com", "000-444-333", "mywebsite.com")
    private var allNecessaryDataUser = User(0, "John Smith", "johnSmith", "johnsmith@email.com", null, null)

    @Test
    fun createAllDataUser() {
        val id = 0
        val name = "John Smith"
        val username = "johnSmith"
        val email = "johnsmith@email.com"
        val phone = "000-444-333"
        val website = "mywebsite.com"

        val newUser = User(id, name, username, email, phone, website)

        assertEquals(newUser, allDataUser)
    }

    @Test
    fun createAllNecessaryDataUser() {
        val id = 0
        val name = "John Smith"
        val username = "johnSmith"
        val email = "johnsmith@email.com"
        val phone = null
        val website = null

        val newUser = User(id, name, username, email, phone, website)

        assertEquals(newUser, allNecessaryDataUser)
    }
}
