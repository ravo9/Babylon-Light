package development.dreamcatcher.babylonlight.apiservice;

import development.dreamcatcher.babylonlight.data.pojo.Post;
import retrofit2.Call;
import java.util.List;

public class ApiUtils {

    private static ApiClient apiClient;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void initializeAPIService() {
        if (apiClient == null)
            apiClient = RetrofitClient.getClient(BASE_URL).create(ApiClient.class);
    }

    public static Call<List<Post>> getPosts() {
        return apiClient.getPosts();
    }
}