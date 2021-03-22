package com.odogwudev.verifycard.app.ui.card.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.odogwudev.verifycard.app.ui.card.fragment.CardResultFragment
import com.odogwudev.verifycard.app.ui.card.viewmodel.MainActivityViewModel
import com.odogwudev.verifycard.app.util.Helpers.enableState
import com.odogwudev.verifycard.core.domain.carddomain.CardDataRespone
import com.odogwudev.verifycard.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: MainActivityViewModel by viewModels()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupListeners()
        setUpObservers()

        setContentView(binding.root)
    }

    private fun setUpObservers() {
        viewModel.cardResponseData.observe(this, cardResponseObserver)
        viewModel.message.observe(this, messageResponseObserver)

    }

    private fun setupListeners() {
        binding.checkCardButton.enableState(false)
        binding.cardNumberEditText.addTextChangedListener {
            it?.let {
                binding.checkCardButton.enableState(it.length >= 5)
            }
        }

        binding.checkCardButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.checkCardButton -> {
                viewModel.getCardData(binding.cardNumberEditText.text.toString())
            }
        }
    }


    private val cardResponseObserver = Observer<CardDataRespone> {
        it?.let {
            CardResultFragment(it).show(supportFragmentManager, "card_result_dialog")
        }
    }

    private val messageResponseObserver = Observer<String> {
        it?.let {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }


}

