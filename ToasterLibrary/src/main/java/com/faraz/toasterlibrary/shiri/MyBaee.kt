package com.faraz.toasterlibrary.shiri

import com.faraz.toasterlibrary.shiri.service.ApiService
import com.faraz.toasterlibrary.shiri.service.ServiceFactory


abstract class MyBaee {

    fun createService(resultClass:Class<*>): ApiService{
        return ServiceFactory.createWebServiceStatic(resultClass)
    }
}