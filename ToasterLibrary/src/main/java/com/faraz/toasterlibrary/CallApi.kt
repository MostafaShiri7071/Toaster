package com.faraz.toasterlibrary

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.ResponseBody


class CallApi : BaseShiri() {

    private val disposable = CompositeDisposable()

    fun userService(bodyClass: Class<*>, url: String): ResponseBody? {
        var abc: ResponseBody? = null
        disposable.add(
            createService(bodyClass::class.java).user(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(response: ResponseBody) {
                        abc = response
                    }

                    override fun onError(e: Throwable) {
                        val er=e.message+""
                    }

                })
        )

        return abc
    }

    fun dispose(){
        disposable.dispose()
    }
}