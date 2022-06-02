package com.example.moduleeleven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moduleeleven.databinding.ActivityMainBinding
import com.example.moduleeleven.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.startActivityButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav()
            findNavController().navigate(action)
        }
        return binding.root
    }

}