package com.example.janken

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.janken.databinding.FragmentResultScreenBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onSubscription
import kotlinx.coroutines.launch

class ResultScreenFragment : Fragment(R.layout.fragment_result_screen) {
    private lateinit var binding: FragmentResultScreenBinding
    private val viewModel: ResultViewModel by viewModels()
    private val mainViewModel: MainActivityViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultScreenBinding.bind(view)
        binding.apply {
            resultViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        val hand = mainViewModel.myHand.value
        val enemy = viewModel.setComHand()

        when (hand!!) {
            JankenHand.GU.raw -> binding.myHandImg.setImageResource(R.drawable.gu)
            JankenHand.CHOKI.raw -> binding.myHandImg.setImageResource(R.drawable.choki)
            else -> binding.myHandImg.setImageResource(R.drawable.pa)
        }

        when (enemy) {
            JankenHand.GU.raw -> binding.comHandImg.setImageResource(R.drawable.com_gu)
            JankenHand.CHOKI.raw -> binding.comHandImg.setImageResource(R.drawable.com_choki)
            JankenHand.PA.raw -> binding.comHandImg.setImageResource(R.drawable.com_pa)
        }

        when (viewModel.getJankenResult(hand, enemy)) {
            0 -> binding.textView.setText(R.string.draw_text)
            1 -> binding.textView.setText(R.string.win_text)
            2 -> binding.textView.setText(R.string.lose_text)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.onClick.collect() {
                    findNavController().popBackStack()
                }
            }
        }
    }
}