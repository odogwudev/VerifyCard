package com.odogwudev.verifycard.di.modules

import com.odogwudev.verifycard.app.retrofit.CardServicesClient
import com.odogwudev.verifycard.core.data.datasource.CardDataSource
import com.odogwudev.verifycard.core.data.repository.CardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CardModule {
    @Singleton
    @Provides
    fun providesCardDataSource(client: CardServicesClient): CardDataSource {
        return CardRepository(client)
    }


}