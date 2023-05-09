package com.example.tabcash.ui.main.history

import com.example.tabcash.databinding.FragmentHistoryBinding


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.herohub.ui.base.BaseFragment
import com.example.tabcash.R
import com.example.tabcash.databinding.FragmentHomeBinding
import com.example.tabcash.model.HistoryResponse
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.math.log

@AndroidEntryPoint
class HistoryFragment: BaseFragment<FragmentHistoryBinding>() {
    override val TAG: String
        get() ="HomeFragment"
    override val layoutIdFragment: Int
        get() = R.layout.fragment_history
  private val mySharedPreferences :MySharedPreferences by lazy {
            MySharedPreferences(requireContext())
  }

    private val viewModel: HistoryViewModel by viewModels()
var history :String?=null
    override fun setup() {
        binding.vm=viewModel

        viewModel.getHistory(mySharedPreferences.getToken().toString())
        log(mySharedPreferences.getToken().toString())
        viewModel.history.observe(viewLifecycleOwner) { respose ->
            history = respose.data?.toString()?:"empety"
            log(history?:"")
        }

    }
    }



