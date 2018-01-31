package banbara23.com.kotlinjacksonsample;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/")
    Observable<PostResponse> post();

    @GET("/")
    Observable<GetResponse> get();
}
