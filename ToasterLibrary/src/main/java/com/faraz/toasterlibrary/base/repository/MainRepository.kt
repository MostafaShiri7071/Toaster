package com.faraz.toasterlibrary.base.repository

import androidx.lifecycle.MutableLiveData
import com.faraz.toasterlibrary.base.response.Resource
import com.faraz.toasterlibrary.shiri.service.ApiService
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

class MainRepository(private val apiService: ApiService){
    var disposable: Disposable? = null
    var progress = MutableLiveData<Int>()
    var error = MutableLiveData<String>()
    var success = MutableLiveData<String>()
    var data = MutableLiveData<Resource<String>>()
    //val turnoverNew = MutableLiveData<Resource<TurnoverResponse>>()
/*
    fun call(url:String){
        //A value of 0 means a loading start
        data.postValue(Resource.loading("0"))
        apiService.getTypeMethod(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ResponseBody> {
                override fun onSuccess(response: ResponseBody) {

                    //A value of 0 means a loading finish
                    data.postValue(Resource.loading("1"))
                    val a=response.byteString().toString()
                    data.postValue(Resource.success(a))

                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onError(e: Throwable) {
                    progress.postValue(0)
                    error.postValue("error in call")
                }
            })
    }

    fun callNew(result:Class<*>,url:String){
        //A value of 0 means a loading start
        val a:String?=null
        data.postValue(Resource.loading("0"))
        apiService.getTypeMethod(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<T> {
                override fun onSuccess(response: ResponseBody) {
                    //A value of 0 means a loading finish
                    data.postValue(Resource.loading("1"))
                    val a=response.byteString().toString()
                    data.postValue(Resource.success(a))

                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onError(e: Throwable) {
                    progress.postValue(0)
                    error.postValue("error in call")
                }
            })
    }
    */
}

