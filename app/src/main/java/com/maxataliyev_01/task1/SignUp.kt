package com.maxataliyev_01.task1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.maxataliyev_01.task1.databinding.FragmentSignUpBinding

class SignUp : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentSignUpBinding.inflate(layoutInflater,container,false)
        binding.btnRegister.setOnClickListener {
//            activity?.let{
//                it.startActivity(Intent (it, LogIn::class.java))
//            }
//        }
            findNavController().navigate(R.id.action_signUp_to_logIn)
        }
        return binding.root
       }
    }
