package com.example.tabcash.ui.main.home

import com.example.herohub.ui.base.BaseFragment
import com.example.tabcash.R
import com.example.tabcash.databinding.FragmentTransactionBinding
import com.example.tabcash.naviagte


class TransactionFragment : BaseFragment<FragmentTransactionBinding>() {
    override val TAG: String
        get() = "HomeFragment"
    override val layoutIdFragment: Int
        get() = R.layout.fragment_transaction
//    private val mySharedPreferences: MySharedPreferences by lazy {
//        MySharedPreferences(requireContext())
//    }

    override fun setup() {
        binding.textCashIn.setOnClickListener {
            naviagte(it, R.id.action_transactionFragment_to_cashInFragment)
        }
        binding.textCashOut.setOnClickListener {
            naviagte(it, R.id.action_transactionFragment_to_cashOutFragment)
        }
        binding.textDonation.setOnClickListener {
            naviagte(it, R.id.action_transactionFragment_to_donationsFragment)
        }


    }



}