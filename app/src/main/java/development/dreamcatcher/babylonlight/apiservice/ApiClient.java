package development.dreamcatcher.babylonlight.apiservice;

import development.dreamcatcher.babylonlight.data.pojo.Comment;
import development.dreamcatcher.babylonlight.data.pojo.Post;
import development.dreamcatcher.babylonlight.data.pojo.User;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import java.util.List;


public interface ApiClient {

    @GET("/posts/")
    @Headers({
            "appVersion: 1.0.0",
            "apiVersion: 1.0.0"
    })
    Single<List<Post>> getPosts();

    @GET("/users/")
    @Headers({
            "appVersion: 1.0.0",
            "apiVersion: 1.0.0"
    })
    Single<List<User>> getUsers();

    @GET("/comments/")
    @Headers({
            "appVersion: 1.0.0",
            "apiVersion: 1.0.0"
    })
    Single<List<Comment>> getComments();
}