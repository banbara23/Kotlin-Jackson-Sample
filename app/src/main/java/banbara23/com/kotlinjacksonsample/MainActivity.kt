package banbara23.com.kotlinjacksonsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private val TAG = "AppCompatActivity"
    private val apiClient = ApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getClick(view: View) {
        apiClient.get()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { res -> Log.d(TAG, res.toString()) },
                        { error -> Log.e(TAG, "{$error.message}") },
                        { Log.d(TAG, "get completed") }
                )
    }

    fun postClick(view: View) {
        apiClient.post()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { res -> Log.d(TAG, res.toString()) },
                        { error -> Log.e(TAG, "{$error.message}") },
                        { Log.d(TAG, "post completed") }
                )
    }
}
