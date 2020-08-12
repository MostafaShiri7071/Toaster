package com.faraz.toasterlibrary.shiri

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
}


