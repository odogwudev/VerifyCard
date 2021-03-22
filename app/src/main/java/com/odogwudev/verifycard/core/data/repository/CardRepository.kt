package com.odogwudev.verifycard.core.data.repository

import com.odogwudev.verifycard.app.retrofit.CardServicesClient
import com.odogwudev.verifycard.app.retrofit.ResponseHelper
import com.odogwudev.verifycard.app.retrofit.safeApiCall
import com.odogwudev.verifycard.core.data.datasource.CardDataSource
import com.odogwudev.verifycard.core.domain.carddomain.CardDataRespone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CardRepository @Inject constructor(private val client: CardServicesClient) : CardDataSource {
    override suspend fun getCardInfo(number: String): ResponseHelper<CardDataRespone> {
        return safeApiCall(Dispatchers.IO) {
            client.getCardData(number)
        }
    }
}