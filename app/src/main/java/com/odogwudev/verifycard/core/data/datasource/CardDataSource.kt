package com.odogwudev.verifycard.core.data.datasource

import com.odogwudev.verifycard.app.retrofit.ResponseHelper
import com.odogwudev.verifycard.core.domain.carddomain.CardDataRespone
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardDataSource {
    suspend fun getCardInfo(number: String): ResponseHelper<CardDataRespone>
}