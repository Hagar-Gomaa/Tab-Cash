package com.example.tabcash.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.herohub.ui.base.BaseFragment
import com.example.tabcash.R
import com.example.tabcash.databinding.FragmentCashInBinding
import com.example.tabcash.databinding.FragmentHistoryBinding
import com.example.tabcash.ui.cashin.CashInViewModel
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CashInFragment : BaseFragment<FragmentCashInBinding>() {
    override val TAG: String
    get() ="HomeFragment"
    override val layoutIdFragment: Int
    get() = R.layout.fragment_cash_in
    private val mySharedPreferences : MySharedPreferences by lazy {
        MySharedPreferences(requireContext())
    }
    private val viewModel: CashInViewModel by viewModels()
    var history :String?=null
    override fun setup() {
        binding.vm=viewModel
         log(mySharedPreferences.getToken().toString())
            viewModel.getbalnce(mySharedPreferences.getToken())
            log(mySharedPreferences.getToken().toString())
            log(mySharedPreferences.getBalance().toString())

    }
}

//log(mySharedPreferences.getToken().toString())
//viewModel.history.observe(viewLifecycleOwner) { respose ->
//    history = respose.data?.toString()?:"empety"
//    log(history?:"")
//}