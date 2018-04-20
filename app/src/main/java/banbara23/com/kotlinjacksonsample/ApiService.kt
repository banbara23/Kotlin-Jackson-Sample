package banbara23.com.kotlinjacksonsample

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("/")
    fun post(): Observable<PostResponse>

    @GET("/")
    fun get(): Observable<GetResponseJ>
}