package com.maxataliyev_01.task1.nav_bottom_menu

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.maxataliyev_01.task1.R
import com.maxataliyev_01.task1.databinding.FragmentProfileBinding

class ProfileFragment:Fragment(R.layout.fragment_profile) {
    private lateinit var ufullname:TextView
    lateinit var binding: FragmentProfileBinding
    lateinit var preferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentProfileBinding.bind(view)
    }


    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_profile,container,false)
        ufullname=view.findViewById(R.id.uFullName)


        return view
    }*/


}