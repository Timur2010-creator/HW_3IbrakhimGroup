package com.example.hw_3ibrakhimgroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.hw_3ibrakhimgroup.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var adapter: OnBoardAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter( getOnBoardList(),::onClickStart,::onSkip)
        binding.vpNotes.adapter = adapter
        binding.dotsIndicator.attachTo(binding.vpNotes)
    }
    private fun onClickStart(){
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.OnBoardFragment,true)
            .build()
        findNavController().navigate(R.id.action_onBoardFragment_to_mainFragment,null,navOptions)
    }
    private fun onSkip(){
        binding.vpNotes.setCurrentItem(2,true)
    }

    fun getOnBoardList(): List<OnBoardModel> {
        return listOf(
            OnBoardModel(
                path = R.raw.board_design_strategy,
                title = "Удобство",
                desc = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи"
            ),
            OnBoardModel(
                path = R.raw.cutting_board,
                title = "Организация",
                desc = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
            ),
            OnBoardModel(
                path = R.raw.top_stocks,
                title = "Синхронизация",
                desc = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
            )
        )
    }
}