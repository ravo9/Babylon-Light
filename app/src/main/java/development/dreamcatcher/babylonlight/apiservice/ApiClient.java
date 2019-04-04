package development.dreamcatcher.babylonlight.apiservice;

import development.dreamcatcher.babylonlight.data.pojo.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;

public interface ApiClient {

    @GET("/posts/")
    @Headers({
            "appVersion: 1.0.0",
            "apiVersion: 1.0.0"
    })
    Call <List<Post>> getPosts();
}