package com.route.news_app_c37.api

import android.util.Log
import com.example.tabcash.api.WebService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object {
        private var retrofit: Retrofit? = null;

        @Synchronized
        private fun getInstance(): Retrofit {
            if (retrofit == null) {
                val loginInterceptor = HttpLoggingInterceptor {
                    Log.e("api", it)
                };
                loginInterceptor.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(loginInterceptor)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl("https://tapcash.000webhostapp.com/api/tapcash/orange/v1/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!;
        }

        fun getApis(): WebService {
            return getInstance().create(WebService::class.java);
        }

    }

}