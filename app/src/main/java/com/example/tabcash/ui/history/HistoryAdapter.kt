package com.example.tabcash.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.enums.HistoryItemType
import com.example.tabcash.R
import com.example.tabcash.databinding.ItemHistoryBinding


class HistoryAdapter(private val list: List<HistoryItem?>) : Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(var viewBinding: ItemHistoryBinding) :
        ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {

        val viewBinding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        bindItems(holder, position)
    }

    private fun bindItems(holder: HistoryViewHolder, position: Int) {

        val historyItem = list[position]
        if (historyItem?.type==HistoryItemType.CASH_IN) holder.viewBinding.icTrasaction.setImageResource(R.drawable.ic_recieve_arrow)
        if (historyItem?.type==HistoryItemType.CASH_OUT) holder.viewBinding.icTrasaction.setImageResource(R.drawable.ic_send_arrow)
        holder.viewBinding.textAmount.text = historyItem?.amount.toString()
        holder.viewBinding.textToPersonName.text = historyItem?.toPersonName

    }

    override fun getItemCount(): Int = list.size

}