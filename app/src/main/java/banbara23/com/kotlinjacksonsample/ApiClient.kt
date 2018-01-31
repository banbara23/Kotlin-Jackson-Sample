package banbara23.com.kotlinjacksonsample

import com.fasterxml.jackson.databind.ObjectMapper
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * APIクライアント
 */
class ApiClient {
    var apiService: ApiService

    init {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://try-now-kplvmhijbn.now.sh")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    /**
     * GET
     */
    fun get(): Observable<GetResponse> =
            apiService.get()

    /**
     * POST
     */
    fun post(): Observable<PostResponse> =
            apiService.post()
}