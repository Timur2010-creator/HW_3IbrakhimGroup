package com.example.hw_3ibrakhimgroup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3ibrakhimgroup.databinding.ItemOnBoardBinding

class OnBoardAdapter(val onBoardList : List<OnBoardModel>): RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardViewHolder {
        return OnBoardViewHolder(ItemOnBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
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

    class OnBoardViewHolder(private val binding: ItemOnBoardBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(onBoardModel: OnBoardModel){
            binding.apply {

                tvTitle.text = OnBoardModel.title
                tvDesc.text = OnBoardModel.desc
            }
        }
    }
}