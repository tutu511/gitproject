package com.example.testapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapplication.R

class RightFragment : Fragment() {

    //重写了onCreateView的方法，通过LayoutInflater的inflater方法将布局xml加载进来
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_right,container,false)
    }
}