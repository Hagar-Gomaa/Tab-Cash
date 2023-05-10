package com.example.tabcash.ui.history

import com.example.tabcash.databinding.FragmentHistoryBinding


import androidx.fragment.app.viewModels
import com.example.enums.HistoryItemType
import com.example.herohub.ui.base.BaseFragment
import com.example.tabcash.R
import com.example.tabcash.utils.MySharedPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
    override val TAG: String
        get() = "HistoryFragment"
    override val layoutIdFragment: Int
        get() = R.layout.fragment_history
    private val mySharedPreferences: MySharedPreferences by lazy {
        MySharedPreferences(requireContext())
    }

    // this list for test adapter becouse api is broke down
    private val historyRecycleList: List<HistoryItem> = listOf(
        HistoryItem(200,"Omar", HistoryItemType.CASH_IN),
        HistoryItem(20,"Mohammed", HistoryItemType.CASH_OUT),
        HistoryItem(500,"Youseef", HistoryItemType.CASH_IN),
        HistoryItem(200,"Ayisha", HistoryItemType.CASH_OUT),
        HistoryItem(700,"Ayisha", HistoryItemType.CASH_OUT),
        HistoryItem(2000,"Ayisha", HistoryItemType.CASH_IN),
        HistoryItem(800,"Youseef", HistoryItemType.CASH_OUT),
        HistoryItem(20, "Omar", HistoryItemType.CASH_OUT),
        HistoryItem(500, "Ayisha",HistoryItemType.CASH_IN),
        HistoryItem(200,"Youseef", HistoryItemType.CASH_OUT),
        HistoryItem(700,"Mohammed", HistoryItemType.CASH_OUT),
        HistoryItem(2000,"Omar",  HistoryItemType.CASH_IN),
        HistoryItem(800,"Youseef", HistoryItemType.CASH_OUT)
    )
    private val historyAdapter = HistoryAdapter(historyRecycleList)
    private val viewModel: HistoryViewModel by viewModels()
    var history: String? = null

    override fun setup() {

        // this comment becouse api is broke down
//        binding.vm = viewModel
//        viewModel.getHistory(mySharedPreferences.getToken().toString())
//        log(mySharedPreferences.getToken().toString())
//        subscribWithLiveData()
        binding.recyclerHistory.adapter = historyAdapter
    }

    private fun subscribWithLiveData() {
        viewModel.history.observe(viewLifecycleOwner) { respose ->
            history = respose.data?.toString() ?: "empety"
        }

    }
}



