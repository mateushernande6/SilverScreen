package br.com.silverscreen.networking

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {
        private val BASE_URL = "https://raw.githubusercontent.com/alura-cursos/mocks-imdb/main/"

        val gson = GsonBuilder().create()
        fun retrofit(): Retrofit {

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()


            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

    }

    val services: MoviesModule
        get() = retrofit().create(MoviesModule::class.java)

}