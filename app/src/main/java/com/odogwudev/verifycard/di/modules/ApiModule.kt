package com.odogwudev.verifycard.di.modules

import com.odogwudev.verifycard.app.retrofit.CardServicesClient
import com.odogwudev.verifycard.app.retrofit.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
open class ApiModule {

    @Singleton
    @Provides
    open fun provideCardClient(): CardServicesClient {
        return RetrofitService.invoke()
    }
}