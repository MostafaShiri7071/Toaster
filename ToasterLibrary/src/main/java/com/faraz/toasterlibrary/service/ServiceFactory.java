package com.faraz.toasterlibrary.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceFactory {

    private static OkHttpClient client;

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz       Java interface of the retrofit service
     * @param baseUrl     REST endpoint url
     * @param resultClass
     * @return retrofit service with defined endpoint
     */
    public static <T,E> T createRetrofitService(final Class<T> clazz, final String baseUrl, E resultClass) {
        return getClient(baseUrl, resultClass).create(clazz);
    }

    public static <E> Retrofit getClient(final String baseUrl, E resultClass) {
        RequestInterceptor interceptor = new RequestInterceptor();
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                //.addConverterFactory(getJsonConverter(resultClass))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    private static GsonConverterFactory getJsonConverter(Class clazz) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(clazz, new StringAdapter())
                .setLenient()
                .create();
        return GsonConverterFactory.create(gson);
    }

    public static <T>ApiService createWebServiceStatic(T resultClass) {
        return ServiceFactory.createRetrofitService(ApiService.class, ApiConstants.Companion.getBASE_URL(), resultClass);
    }
}

    /*public static ApiService createWebService(Class resultClass) {
        return ServiceFactory.createRetrofitService(ApiService.class, ServiceHelperNew.INSTANCE(), resultClass);
    }
    public static ApiService createWebServicenNew(Class resultClass) {
        return ServiceFactory.createRetrofitService(ApiService.class, ServiceHelper.SERVICE_BASE_URL_Dynamic, resultClass);
    }*/

