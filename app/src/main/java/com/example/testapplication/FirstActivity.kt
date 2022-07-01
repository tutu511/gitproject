package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.testapplication.data.User
import com.example.testapplication.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    //xml的文件名叫做"activity_main"，那就会生成ActivityMainBinding类
    //lateinit延迟初始化
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //给当前的Activity加载布局
        binding = DataBindingUtil.setContentView(this,R.layout.activity_first)
        //设置数据类(User)给binding
        binding.user = User("TUTU",22)

        //按钮点击事件---intent显式
        binding.button1.setOnClickListener {
            //输入框的数据----getText等价于.text
            val data = binding.edittextNeed.text.toString()
            //跳转到SecondActivity
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("data",data)
            startActivity(intent)
        }

        //文本框的点击事件
        binding.textviewName.setOnClickListener {
            binding.progressBar.progress = binding.progressBar.progress + 20
        }

        //弹出对话框--点击文本框
        binding.textviewAge.setOnClickListener {
            //.apply就等于下面的都是省略AlertDialog.Builder.
            AlertDialog.Builder(this@FirstActivity).apply {
                setTitle("Are you happy?")
                setMessage("I do not care about it")
                setPositiveButton("Yes"){
                    dialog, which -> dialog.dismiss()
                }
                setNegativeButton("No"){
                    dialog, which -> Toast.makeText(this@FirstActivity,"Hope you can enjoy it",Toast.LENGTH_SHORT).show()
                }
                show()
            }
        }

    }
}
