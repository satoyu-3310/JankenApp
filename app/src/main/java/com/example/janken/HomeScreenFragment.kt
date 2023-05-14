package com.example.janken

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.janken.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel: HomeViewModel by viewModels()
    private val mainViewModel: MainActivityViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)
        binding.apply {
            homeViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        viewModel.apply {
            guButton.observe(viewLifecycleOwner) {
                if (it) {
                    mainViewModel.setResult(JankenHand.GU.raw)
                    findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToResultScreenFragment())
                    viewModel.offClickGuButton()
                }
            }
            chokiButton.observe(viewLifecycleOwner) {
                if (it) {
                    mainViewModel.setResult(JankenHand.CHOKI.raw)
                    findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToResultScreenFragment())
                    viewModel.offClickChokiButton()
                }
            }
            paButton.observe(viewLifecycleOwner) {
                if (it) {
//                    mainViewModel.setResult(JankenHand.PA.raw)
                    findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToResultScreenFragment())
                    viewModel.offClickPaButton()
                }
            }
        }
    }
}