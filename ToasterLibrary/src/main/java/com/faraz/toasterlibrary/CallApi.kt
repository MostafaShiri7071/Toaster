package com.faraz.toasterlibrary

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.ResponseBody


class CallApi : BaseShiri() {

    private val disposable = CompositeDisposable()

    fun userServiceGet(bodyClass: Class<*>, url: String): ResponseBody? {
        var abc: ResponseBody? = null
        disposable.add(
            createService(bodyClass::class.java).user(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(response: ResponseBody) {
                        abc = response
                    }

                    override fun onError(e: Throwable) {
                        val er = e.message + ""
                    }

                })
        )

        return abc
    }

    fun userServiceGetNew(bodyClass: Class<*>, url: String,myCall: MyCall){
        //var abc: ResponseBody? = null
        myCall.loading(1)
        disposable.add(
            createService(bodyClass::class.java).user(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(response: ResponseBody) {
                        myCall.loading(0)
                        myCall.success(response)
                        //abc = response
                    }

                    override fun onError(e: Throwable) {
                        myCall.error(e.message)
                    }

                })
        )

    }

    fun userServicePost(bodyClass: Class<*>,resultClass: Class<*>, url: String): ResponseBody? {
        var abc: ResponseBody? = null
        disposable.add(createService(bodyClass::class.java).userNew(url, resultClass::class.java)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(response: ResponseBody) {
                        abc = response
                    }

                    override fun onError(e: Throwable) {
                        val er = e.message + ""
                    }

                })
        )

        return abc
    }

    fun dispose() {
        disposable.dispose()
    }

    interface MyCall{
        fun loading(i: Int)
        fun success(response: ResponseBody)
        fun error(message: String?)
    }
}


