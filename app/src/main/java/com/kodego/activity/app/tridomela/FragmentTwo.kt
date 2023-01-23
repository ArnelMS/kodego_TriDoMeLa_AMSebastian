package com.kodego.activity.app.tridomela

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kodego.activity.app.tridomela.databinding.FragmentOneBinding
import com.kodego.activity.app.tridomela.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {

    lateinit var binding : FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root

    }
}