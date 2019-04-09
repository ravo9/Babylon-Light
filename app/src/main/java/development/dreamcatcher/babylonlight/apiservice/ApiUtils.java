package development.dreamcatcher.babylonlight.apiservice;

import development.dreamcatcher.babylonlight.data.pojo.Comment;
import development.dreamcatcher.babylonlight.data.pojo.Post;
import development.dreamcatcher.babylonlight.data.pojo.User;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import java.util.List;

public class ApiUtils {

    private static ApiClient apiClient;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void initializeAPIService() {
        if (apiClient == null)
            apiClient = RetrofitClient.getClient(BASE_URL).create(ApiClient.class);
    }

    public static Single<List<Post>> getPosts() {
        return apiClient.getPosts();
    }

    public static Single<List<User>> getUsers() {
        return apiClient.getUsers();
    }

    public static Single<List<Comment>> getComments() {
        return apiClient.getComments();
    }
}