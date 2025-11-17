package com.example.hw_3ibrakhimgroup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3ibrakhimgroup.databinding.ItemOnBoardBinding

class OnBoardAdapter(val onBoardList : List<OnBoardModel>,val onStart:()-> Unit,val onSkip:()-> Unit):
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
                image.setAnimation(onBoardModel.path)
            }
            if (absoluteAdapterPosition == onBoardList.size -1) {
                binding.tvSkip.visibility = View.INVISIBLE
                binding.btnStart.setOnClickListener {
                    onStart()
                }
            }else{
                binding.btnStart.visibility = View.INVISIBLE
                binding.tvSkip.setOnClickListener {
                    onSkip()
                }
            }
                    }
                }
            }