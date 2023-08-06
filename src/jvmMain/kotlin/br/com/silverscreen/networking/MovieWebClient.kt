package br.com.silverscreen.networking

import br.com.silverscreen.model.MoviesResponse
import br.com.silverscreen.networking.NetworkUtils.Companion.gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieWebClient {

    private val serviceMovie = NetworkUtils().services

     fun findTop250Movies(callback: (MoviesResponse?) -> Unit) {

        serviceMovie.findTop250Movies().enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(
                call: Call<ResponseBody?>,
                response: Response<ResponseBody?>,
            ) {
                val responseBody = response.body()?.string()

                if (responseBody != null) {

                    val movies = gson.fromJson(responseBody, MoviesResponse::class.java)

                    callback(movies)

                } else {
                    callback(null)
                }

            }

            override fun onFailure(
                call: Call<ResponseBody?>,
                t: Throwable,
            ) {

            }
        })
    }


}