package com.faraz.toasterlibrary.base.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val mainModule = module {
    //factory<ItemRepository> { ItemRepositoryImpl(get()) }
    //factory<FactureRepository> { FactureRepositoryImpl(get(), androidApplication().contentResolver) }
}