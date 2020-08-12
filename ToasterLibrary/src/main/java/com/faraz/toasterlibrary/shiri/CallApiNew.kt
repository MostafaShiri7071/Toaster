package com.faraz.toasterlibrary.shiri

import com.google.gson.JsonElement
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

class CallApiNew: MyBaee() {

     fun <Any> dealNew(resultType: Class<Any>,baseUrl: String?,functionResult: (Any) -> Unit,functionError: (String) -> Unit) {
        val servoce=createService(resultType).userShiriNew<Any>(baseUrl)
        servoce.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object: Observer<Any> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: Any) {
                    functionResult.invoke(t)
                }

                override fun onError(e: Throwable) {
                    e.message?.let { functionError.invoke(it) }
                }

            })
    }

     fun  deal(baseUrl: String?,functionResult: (JsonElement) -> Unit,functionError: (String) -> Unit) {
        val servoce=createService(Void::class.java).user(baseUrl)
        servoce.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object: Observer<JsonElement> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: JsonElement) {
                    functionResult.invoke(t)
                }

                override fun onError(e: Throwable) {
                    e.message?.let { functionError.invoke(it) }
                }

            })
    }

     fun  dealllll(baseUrl: String?) {
        val servoce=createService(String::class.java).user(baseUrl)
        servoce.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object: Observer<JsonElement> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: JsonElement) {
                   // functionResult.invoke(t)
                }

                override fun onError(e: Throwable) {
                    //e.message?.let { functionError.invoke(it) }
                }

            })
    }

     fun  dea(baseUrl: String?) {
        val servoce=createService(Void::class.java).user(baseUrl)
        servoce.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object: Observer<JsonElement> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: JsonElement) {
                   // functionResult.invoke(t)
                }

                override fun onError(e: Throwable) {
                    //e.message?.let { functionError.invoke(it) }
                }

            })
    }

    fun  dealPost(body:Class<*>,baseUrl: String?,functionResult: (JsonElement) -> Unit,functionError: (String) -> Unit) {
        val servoce=createService(Void::class.java).userPost(baseUrl,body::class.java)
        servoce.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object: Observer<JsonElement> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: JsonElement) {
                    functionResult.invoke(t)
                }

                override fun onError(e: Throwable) {
                    e.message?.let { functionError.invoke(it) }
                }

            })
    }

    fun  dealPostNew(body:Class<*>,baseUrl: String?,functionResult: (JsonElement) -> Unit,functionError: (String) -> Unit) {
        val servoce=createService(body).userPost(baseUrl,body::class.java)
        servoce.subscribeOn(Schedulers.newThread())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object: Observer<JsonElement> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: JsonElement) {
                    functionResult.invoke(t)
                }

                override fun onError(e: Throwable) {
                    e.message?.let { functionError.invoke(it) }
                }

            })
    }
}


