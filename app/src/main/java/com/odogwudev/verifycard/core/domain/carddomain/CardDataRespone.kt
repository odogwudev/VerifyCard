package com.odogwudev.verifycard.core.domain.carddomain

import com.google.gson.annotations.SerializedName

data class CardDataRespone(
    @SerializedName("bank")
    var bank: Bank?,
    @SerializedName("brand")
    var brand: String?,
    @SerializedName("country")
    var country: Country?,
    @SerializedName("number")
    var number: Number?,
    @SerializedName("prepaid")
    var prepaid: Boolean?,
    @SerializedName("scheme")
    var scheme: String?,
    @SerializedName("type")
    var type: String?
)

data class Bank(
    @SerializedName("city")
    var city: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("url")
    var url: String?
)

data class Country(
    @SerializedName("alpha2")
    var alpha2: String?,
    @SerializedName("currency")
    var currency: String?,
    @SerializedName("emoji")
    var emoji: String?,
    @SerializedName("latitude")
    var latitude: Int?,
    @SerializedName("longitude")
    var longitude: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("numeric")
    var numeric: String?
)

data class Number(
    @SerializedName("length")
    var length: Int?,
    @SerializedName("luhn")
    var luhn: Boolean?
)