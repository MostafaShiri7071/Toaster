package com.faraz.toasterlibrary.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

interface ApiService {

    companion object {
        const val BASE_URL = "http://www.omdbapi.com/"
        const val BASE_URL_NEW = "https://service.idabir.com/api/"
    }

    @Headers("User-Agent: <god>")
    @GET
    fun user(@Url url: String?): Single<ResponseBody>


}