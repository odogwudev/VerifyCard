package com.odogwudev.verifycard.app.ui.card.viewmodel

import android.util.Log
import androidx.hilt.Assisted

import androidx.lifecycle.*
import com.odogwudev.verifycard.app.Repo
import com.odogwudev.verifycard.app.retrofit.ResponseHelper
import com.odogwudev.verifycard.core.domain.carddomain.CardDataRespone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel(), LifecycleObserver {
    private val _cardResponseData = MutableLiveData<CardDataRespone>()
    val cardResponseData = _cardResponseData

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message





    fun getCardData(number: String) {


        viewModelScope.launch {
            val request = repo.getCardDate(number)

            withContext(Dispatchers.Main) {
                when (request) {
                    is ResponseHelper.Success -> {
                        _cardResponseData.value = request.value
                    }

                    is ResponseHelper.GenericError -> {
                        _message.value =
                            request.error ?: request.error
                    }

                    is ResponseHelper.NetworkError -> {
                        _message.value = request.message
                    }
                }
            }
        }

    }
}