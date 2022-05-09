package com.example.barbare_shonia.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.barbare_shonia.R
import com.example.barbare_shonia.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)

        binding.leftButton.setOnClickListener {
            navigate()
        }

        sharedPreferences = activity?.getSharedPreferences("name", Context.MODE_PRIVATE)!!
        val name = sharedPreferences.getString("User_name",null)

        binding.userName.text = "Hello, $name"

        return binding.root
    }

    private fun navigate(){
        findNavController().navigate(R.id.action_accountFragment_to_loginFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}