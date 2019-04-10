package development.dreamcatcher.babylonlight.data.pojo

import com.google.gson.annotations.SerializedName


data class User(
        @SerializedName("id")           val id: Int,
        @SerializedName("name")         val name: String,
        @SerializedName("username")     val username: String,
        @SerializedName("email")        val email: String,
        @SerializedName("phone")        val phone: String?,
        @SerializedName("website")      val website: String?) {

        // There is a situation where we use data class in Kotlin with GSON.
        // That requires us to use a customized initializer, as GSON doesn't really call
        // constructor, and otherwise avatarUrl (which is not processed by it) would be set as NULL.

        var avatarUrl: String = ""
                get() {
                        if (field == null) initAvatarUrl()
                        return field
                }

        private fun initAvatarUrl() {
                avatarUrl = "https://api.adorable.io/avatars/$id"
        }
}