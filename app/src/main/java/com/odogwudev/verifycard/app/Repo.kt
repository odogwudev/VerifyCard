package com.odogwudev.verifycard.app

import com.odogwudev.verifycard.core.data.interactor.CardInteractor
import javax.inject.Inject

class Repo @Inject constructor(private val cardInteractor: CardInteractor) {
    suspend fun getCardDate(number: String) = cardInteractor.getCardData(number)
}