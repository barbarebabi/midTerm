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
import com.example.barbare_shonia.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        sharedPreferences = activity?.getSharedPreferences("name", Context.MODE_PRIVATE)!!
        val edit = sharedPreferences.edit()

        binding.profileButton.setOnClickListener {
            navigate()
        }

        binding.rightButton.setOnClickListener {
            val name = binding.PersonName.text.toString()
            edit?.putString("User_name", name)?.apply()
            navigate()
        }

        return binding.root
    }

    private fun navigate(){
        findNavController().navigate(R.id.action_loginFragment_to_accountFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}