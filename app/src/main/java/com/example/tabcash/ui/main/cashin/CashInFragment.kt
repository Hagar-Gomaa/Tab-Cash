package com.example.tabcash.ui.main.home

import androidx.fragment.app.viewModels
import com.example.herohub.ui.base.BaseFragment
import com.example.tabcash.R
import com.example.tabcash.databinding.FragmentCashInBinding
import com.example.tabcash.naviagte
import com.example.tabcash.ui.main.cashin.CashInNavigator
import com.example.tabcash.ui.main.cashin.CashInViewModel
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CashInFragment : BaseFragment<FragmentCashInBinding>(), CashInNavigator {
    override val TAG: String
        get() = "HomeFragment"
    override val layoutIdFragment: Int
        get() = R.layout.fragment_cash_in
    private val mySharedPreferences: MySharedPreferences by lazy {
        MySharedPreferences(requireContext())
    }
    private val viewModel: CashInViewModel by viewModels()

    override fun setup() {
        val token =mySharedPreferences.getToken()
        binding.vm=viewModel
        viewModel.getbalnce(token)
        val balance =viewModel.balance.get().toString()

        binding.layoutBalance.textAmontNumber.text=balance
        mySharedPreferences.saveBalance(balance)
        binding.buttonSend.setOnClickListener{
            val amount =binding.editTextAmount.text.toString()
            viewModel.deposite(token,900)
           log(balance.toString())
        }
    }
    override fun goToTransactions() {
        naviagte(requireView(), R.id.action_cashInFragment_to_transactionFragment)
    }
}

//log(mySharedPreferences.getToken().toString())
//viewModel.history.observe(viewLifecycleOwner) { respose ->
//    history = respose.data?.toString()?:"empety"
//    log(history?:"")
//}