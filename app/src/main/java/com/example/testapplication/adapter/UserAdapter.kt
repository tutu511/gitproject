package com.example.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.data.User

//要传递userlist， ：就是继承于RecyclerView.Adapter<UserAdapter.ViewHolder>()
class UserAdapter(val userList:List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    //内部类viewHolder继承于RecyclerView.ViewHolder
    //并且在ViewHolder的主构造函数中传入一个view的参数，view的参数就是recyclerView的子项的外层布局
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView = view.findViewById(R.id.name)
        val userAge: TextView = view.findViewById(R.id.age)
    }

    //用来创建viewHolder实例，把加载出来的布局传入构造函数中，最后将viewHolder实例返回
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userList.size

    //对recyclerView的子项进行赋值
    //每个子项被滚动到屏幕内时执行，
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.name
        holder.userAge.text = user.age.toString()
    }

}