package com.faraz.toasterlibrary.base.service

import com.faraz.toasterlibrary.BaseShiri
import com.faraz.toasterlibrary.Shiri
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiService{

    companion object {
        const val BASE_URL = "http://www.omdbapi.com/"
        const val BASE_URL_NEW = "https://service.idabir.com/api/"
    }

    @Headers("User-Agent: <god>")
    @GET
    fun user(@Url url: String?): Single<ResponseBody>

    @Headers("User-Agent: <god>")
    @POST
    fun userNew(@Url url: String?,@Body shiri:Class<*>): Single<ResponseBody>

    @Headers("User-Agent: <god>")
    @GET
    fun getTypeMethod(@Url url: String?): Single<ResponseBody>

    @Headers("User-Agent: <god>")
    @GET
    fun getTypeMethodNew(@Url url: String?): Single<Class<*>>

    @Headers("User-Agent: <god>")
    @POST
    fun postTypeMethod(@Url url: String?,@Body body:Class<*>): Single<ResponseBody>

}