package com.ubaya.anmp_week1

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ubaya.anmp_week1.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var num1 = (0..99).random()
        var num2 = (0..99).random()
        var total = (num1 + num2).toString()
        var point = 0

        binding.txtNum1.text = num1.toString()
        binding.txtNum2.text = num2.toString()

        if (arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's turn"

        }

//        binding.btnBack.setOnClickListener {
//            val action = GameFragmentDirections.actionMainFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
        binding.btnSubmit.setOnClickListener {
            var totalInput = binding.txtInput.text.toString()

            if (total != totalInput) {
                val action = GameFragmentDirections.actionResultFragment(point)
                Navigation.findNavController(it).navigate(action)
            }

            point += 1

            num1 = (0..99).random()
            num2 = (0..99).random()
            total = (num1 + num2).toString()
            binding.txtNum1.text = num1.toString()
            binding.txtNum2.text = num2.toString()
            binding.txtInput.setText("")
        }
    }
}