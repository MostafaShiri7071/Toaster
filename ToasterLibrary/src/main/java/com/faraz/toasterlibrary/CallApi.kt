package com.faraz.toasterlibrary

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
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
    open fun deal(resultType: Class<T>,baseUrl: String?,body: Class<*>,functionResult: (T) -> Unit,functionError: (String) -> Unit,result:Class<*>) {
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

    open fun dealNew(resultType: Class<Any>,baseUrl: String?,body: Class<*>,functionResult: (Any) -> Unit,functionError: (String) -> Unit,result:Class<*>) {
        val servoce=createService(resultType)?.userShiriNew(baseUrl)
        servoce?.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object:Observer<Any>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: Any) {
                    functionResult.invoke(t)
                }

                override fun onError(e: Throwable) {}

            })
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


