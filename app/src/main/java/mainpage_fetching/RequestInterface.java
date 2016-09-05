package mainpage_fetching;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vikash on 7/20/2016.
 */
public interface RequestInterface {

    @GET("android/jsonandroid")
    Call<JsonResponse> getJSON();
}
