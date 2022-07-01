package com.example.testapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentLeftBinding

class LeftFragment : Fragment() {

    private lateinit var binding : FragmentLeftBinding

    //重写了onCreateView的方法，通过LayoutInflater的inflate方法将布局（xml）加载进来
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_left,container,false)
        return binding.root

    }


}