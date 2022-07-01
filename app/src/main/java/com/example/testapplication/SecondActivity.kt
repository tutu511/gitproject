package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapplication.adapter.UserAdapter
import com.example.testapplication.data.User
import com.example.testapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    //用户列表数据
    private val userList = ArrayList<User>();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second)

        //接受传递过来的值
        val value = intent.getStringExtra("data")
        Log.d("SecondActivity","intent data is $value")

        //初始化用户列表数据
        initUser()
        val layoutManager = LinearLayoutManager(this)
        binding.recycleView.layoutManager = layoutManager
        val adapter = UserAdapter(userList)
        binding.recycleView.adapter = adapter
    }

    //初始化用户列表数据
    private fun initUser() {
        //循环执行2次
       repeat(2) {
           userList.add(User("TT",22))
           userList.add(User("FF",11))
           userList.add(User("YY",33))
           userList.add(User("CC",55))
           userList.add(User("II",88))
       }
    }
}