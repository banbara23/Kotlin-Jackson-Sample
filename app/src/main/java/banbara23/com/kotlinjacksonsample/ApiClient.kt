package banbara23.com.kotlinjacksonsample

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
                .baseUrl("https://try-now-btbshmsmcr.now.sh") // null有り
//                .baseUrl("https://try-now-maiiqgzyye.now.sh") // nullなし
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(JacksonHelper.createObjectMapper()))
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    /**
     * GET
     */
    fun get(): Observable<GetResponseJ> =
            apiService.get()

    /**
     * POST
     */
    fun post(): Observable<PostResponse> =
            apiService.post()
}