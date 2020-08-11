package com.faraz.toasterlibrary.base.service

import com.faraz.toasterlibrary.service.ApiConstants.Companion.BASE_URL
import com.faraz.toasterlibrary.service.ApiService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceFactoryNew {
    private var client: OkHttpClient? = null

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz       Java interface of the retrofit service
     * @param baseUrl     REST endpoint url
     * @param resultClass
     * @return retrofit service with defined endpoint
     */
    fun <T> createRetrofitService(
        clazz: Class<T>?,
        baseUrl: String?,
        resultClass: Class<*>?
    ): T {
        return getClient(baseUrl, resultClass).create(clazz)
    }

    fun getClient(baseUrl: String?, resultClass: Class<*>?): Retrofit {
        val interceptor = RequestInterceptor()
        client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(getJsonConverter(resultClass))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    private fun getJsonConverter(clazz: Class<*>?): GsonConverterFactory {
        val gson = GsonBuilder()
            .registerTypeAdapter(clazz, StringAdapter())
            .setLenient()
            .create()
        return GsonConverterFactory.create(gson)
    }

   /* fun createWebServiceStatic(resultClass: Class<*>?): ApiService?{
        return createRetrofitService(
            ApiService::class.java,
            BASE_URL,
            resultClass
        )
    }*/
}