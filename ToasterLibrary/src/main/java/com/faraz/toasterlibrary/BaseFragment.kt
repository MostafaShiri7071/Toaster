package com.faraz.toasterlibrary

import com.faraz.toasterlibrary.service.ApiService
import com.faraz.toasterlibrary.service.ServiceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

abstract class BaseShiri<T>{

    fun <T> createService(resultClass:T): ApiService<*>? {
        return ServiceFactory.createWebServiceStatic(resultClass)
    }

    private val disposable = CompositeDisposable()
/*
    open fun <T> deal(clazz: Class<T>?,baseUrl: String?,body: Class<*>){
        disposable.add(
            createService(body::class.java).userShiri<T>("url")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<T>() {
                    override fun onSuccess(response: T) {

                    }

                    override fun onError(e: Throwable) {
                        val er = e.message + ""
                    }

                })
        )
    }
*/
}