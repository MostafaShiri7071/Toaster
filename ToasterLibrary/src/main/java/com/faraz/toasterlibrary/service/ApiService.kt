package com.faraz.toasterlibrary.service

import com.faraz.toasterlibrary.BaseShiri
import com.faraz.toasterlibrary.Shiri
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiService<T>{

    companion object {
        const val BASE_URL = "http://www.omdbapi.com/"
        const val BASE_URL_NEW = "https://service.idabir.com/api/"
    }

    @Headers("User-Agent: <god>")
    @GET
    fun user(@Url url: String?): Single<ResponseBody>

    @Headers("User-Agent: <god>")
    @GET
    fun <T> userShiri(@Url url: String?): Single<T>

    @Headers("User-Agent: <god>")
    @GET
    fun userShiriNew(@Url url: String?): Observable<Any>

    @Headers("User-Agent: <god>")
    @POST
    fun userNew(@Url url: String?,@Body shiri:Class<*>): Single<ResponseBody>

}