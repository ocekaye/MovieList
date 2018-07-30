package id.setyatmoko.movielist.API

import android.content.Context
import id.setyatmoko.movielist.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {
    companion object {
        private const val API_BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_BASE_IMAGE = "https://image.tmdb.org/t/p/w300"
        fun getImage(url : String) : String{
            return "$API_BASE_IMAGE$url"
        }
        fun <S : Any?> createService(context: Context, serviceClass: Class<S>): S {
            val token = context.resources.getString(R.string.api_key_v3)
            val interceptor = Interceptor {
                val originalRequest = it.request()
                val originalHttpUrl = originalRequest.url()
                val url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", token)
                        .build()
                val request = originalRequest.newBuilder()
                        .url(url)
                        .build()
                it.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder().run {
                addInterceptor(interceptor)
                build()
            }
            val retrofit = Retrofit.Builder().run {
                addConverterFactory(GsonConverterFactory.create())
                client(okHttpClient)
                baseUrl(API_BASE_URL)
                build()
            }
            return retrofit.create(serviceClass)
        }
    }
}