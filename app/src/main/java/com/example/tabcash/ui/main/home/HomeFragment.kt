package com.example.tabcash.ui.main.home

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
import com.example.tabcash.ui.main.cashin.CashInViewModel
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val TAG: String
        get() ="HomeFragment"
    override val layoutIdFragment: Int
        get() = R.layout.fragment_home
    private val mySharedPreferences : MySharedPreferences by lazy {
        MySharedPreferences(requireContext())
    }
    private val viewModel: CashInViewModel by viewModels()
     override fun setup() {
            viewModel.getbalnce(mySharedPreferences.getToken().toString())


        }
    }



