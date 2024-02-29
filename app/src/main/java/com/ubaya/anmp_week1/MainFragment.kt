package com.ubaya.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.anmp_week1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView( //load layout
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { //mengakses layout (button, dll)
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener{
            val playerName = binding.txtName.text.toString()

//            untuk pindah fragment pakai navigation (butuh argument krn diminta di gameFragment)
            val action = MainFragmentDirections.actionGameFragment(playerName)

            Navigation.findNavController(it).navigate(action)
        }
    }
}