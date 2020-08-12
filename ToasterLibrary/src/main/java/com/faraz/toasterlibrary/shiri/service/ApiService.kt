package com.faraz.toasterlibrary.shiri.service

import com.google.gson.JsonElement
import io.reactivex.Observable
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
    fun <Any> userShiriNew(@Url url: String?): Observable<Any>

    @Headers("User-Agent: <god>")
    @GET
    fun user(@Url url: String?): Observable<JsonElement>

    @Headers("User-Agent: <god>")
    @POST
    fun userPost(@Url url: String?,@Body body:Class<*>): Observable<JsonElement>
}