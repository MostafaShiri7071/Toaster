package com.faraz.toasterlibrary

import com.faraz.toasterlibrary.service.ApiService
import com.faraz.toasterlibrary.service.ServiceFactory

abstract class BaseShiri{

    fun createService(resultClass: Class<*>): ApiService {
        return ServiceFactory.createWebServiceStatic(resultClass)
    }

}