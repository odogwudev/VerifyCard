package com.odogwudev.verifycard.di.modules

import com.odogwudev.verifycard.app.Repo
import com.odogwudev.verifycard.core.data.interactor.CardInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
object RepoModule {

    @ViewModelScoped
    @Provides
    fun providesRepo(cardInteractor: CardInteractor): Repo {
        return Repo(cardInteractor)
    }


}