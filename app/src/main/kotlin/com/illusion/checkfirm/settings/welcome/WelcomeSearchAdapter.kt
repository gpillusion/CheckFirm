package com.illusion.checkfirm.settings.welcome

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.illusion.checkfirm.R
import com.illusion.checkfirm.databinding.RowSearchItemsBinding

class WelcomeSearchAdapter(private val context: Context, private var modelList: List<String>, private var cscList: List<String>,
                           val onClickListener: MyAdapterListener) : RecyclerView.Adapter<WelcomeSearchAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: RowSearchItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val delete = binding.delete
        var device = binding.device

        init {
            delete.setOnClickListener { onClickListener.onDeleteClicked(bindingAdapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowSearchItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = modelList[position]
        val csc = cscList[position]

        holder.device.text = String.format(context.getString(R.string.device_format), model, csc)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    interface MyAdapterListener {
        fun onDeleteClicked(position: Int)
    }
}
