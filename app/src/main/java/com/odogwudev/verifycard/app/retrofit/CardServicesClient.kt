package com.odogwudev.verifycard.app.retrofit

import com.odogwudev.verifycard.core.domain.carddomain.CardDataRespone
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardServicesClient {
    @GET("/{number}")
    suspend fun getCardData(@Path("number") number: String): Response<CardDataRespone>

}