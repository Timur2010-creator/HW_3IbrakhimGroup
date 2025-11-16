package com.example.hw_3ibrakhimgroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }
    private fun onClickStart(){
        findNavController().navigate(R.id.action_onBoardFragment_to_mainFragment)
    }
    private fun onSkip(position: Int){
        binding.vpNotes.currentItem = position + 1
    }

    fun getOnBoardList(): List<OnBoardModel> {
        return listOf(
            OnBoardModel(
                title = "Удобство",
                desc = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно"
            ),
            OnBoardModel(
                title = "Организация",
                desc = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
            ),
            OnBoardModel(
                title = "Синхронизация",
                desc = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
            )
        )
    }
}