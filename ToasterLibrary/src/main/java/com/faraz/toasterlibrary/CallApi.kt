package com.faraz.toasterlibrary

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.ResponseBody


open class CallApi<T> : BaseShiri<T>() {

    private val disposable = CompositeDisposable()
/*
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

    fun userServiceGetNew(bodyClass: Class<*>, url: String, myCall: MyCall) {
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

    fun userServicePost(bodyClass: Class<*>, resultClass: Class<*>, url: String): ResponseBody? {
        var abc: ResponseBody? = null
        disposable.add(
            createService(bodyClass::class.java).userNew(url, resultClass::class.java)
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
*/
    open fun <T>  deal(resultType: Class<T>,baseUrl: String?,body: Class<*>,functionResult: (T) -> Unit,functionError: (String) -> Unit,result:Class<*>) {
        disposable.add(createService(body::class.java)?.userShiri<T>(baseUrl)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())!!.subscribeWith(object : DisposableSingleObserver<T>() {
                    override fun onSuccess(response: T) {
                        functionResult.invoke(response)
                    }

                    override fun onError(e: Throwable) {
                        e.message?.let { functionError.invoke(it) }
                    }

                })
        )
    }

    fun dispose() {
        disposable.dispose()
    }

    interface MyCall {
        fun loading(i: Int)
        fun success(response: ResponseBody)
        fun error(message: String?)
    }

    interface MyCallNew<T> {
        fun loading(i: Int)
        fun success(response: T)
        fun error(message: String?)
    }
}


