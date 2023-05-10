package com.example.tabcash.ui.main.home

import androidx.fragment.app.viewModels
import com.example.herohub.ui.base.BaseFragment
import com.example.tabcash.R
import com.example.tabcash.databinding.FragmentHomeBinding
import com.example.tabcash.ui.cashin.CashInViewModel
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint

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



