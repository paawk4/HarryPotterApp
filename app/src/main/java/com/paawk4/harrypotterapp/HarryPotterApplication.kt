package com.paawk4.harrypotterapp

import android.app.Application
import com.paawk4.harrypotterapp.di.repositoriesModule
import com.paawk4.harrypotterapp.di.useCasesModule
import com.paawk4.harrypotterapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HarryPotterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@HarryPotterApplication)
            modules(listOf(repositoriesModule, viewModelsModule, useCasesModule))
        }
    }

}