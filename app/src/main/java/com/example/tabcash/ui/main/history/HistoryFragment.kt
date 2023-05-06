package com.example.tabcash.ui.main.history

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.herohub.ui.base.BaseFragment
import com.example.tabcash.R
import com.example.tabcash.databinding.FragmentHistoryBinding


class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val viewModel: ViewModel by viewModels()
    override val layoutIdFragment = R.layout.fragment_history
    //private val arguments: Args by navArgs()
    override fun setup() {
//        viewModel.getHistory(arguments.eventId)
    }
}


