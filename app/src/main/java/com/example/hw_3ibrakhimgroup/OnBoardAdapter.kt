package com.example.hw_3ibrakhimgroup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3ibrakhimgroup.databinding.ItemOnBoardBinding

class OnBoardAdapter(val onBoardList : List<OnBoardModel>,val onStart:()-> Unit,val onSkip:(Int)-> Unit):
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: OnBoardViewHolder,
        position: Int
    ) {
        holder.onBind(onBoardList[position])
    }

    override fun getItemCount(): Int {
        return onBoardList.size;
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(onBoardModel: OnBoardModel) {
            binding.apply {
                tvTitle.text = onBoardModel.title
                tvDesc.text = onBoardModel.desc
            }
            binding.tvSkip.setOnClickListener {
                onSkip(position)
            }
            binding.btnStart.setOnClickListener {
                onStart()
            }
            if (adapterPosition == onBoardList.size -1) {
                binding.tvSkip.visibility = View.INVISIBLE
            }else{
                binding.btnStart.visibility = View.INVISIBLE
            }
        }
    }
}