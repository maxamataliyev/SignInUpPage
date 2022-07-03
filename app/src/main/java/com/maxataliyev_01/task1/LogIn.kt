package com.maxataliyev_01.task1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.maxataliyev_01.task1.databinding.FragmentLogInBinding


class LogIn : Fragment() {
    lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLogInBinding.inflate(layoutInflater)
        binding.btnLogIn.setOnClickListener {
            findNavController().navigate(R.id.action_logIn_to_mainActivity)
        }
        binding.btnSignUp.setOnClickListener {
//            activity?.let {
//                it.startActivity(Intent(it,MainActivity::class.java))
//            }
            findNavController().navigate(R.id.action_logIn_to_signUp)
        }
        return binding.root



    }

}