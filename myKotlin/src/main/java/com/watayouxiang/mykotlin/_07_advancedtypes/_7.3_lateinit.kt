package com.watayouxiang.mykotlin._07_advancedtypes

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.watayouxiang.mykotlin.R

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2020/11/11
 *     desc   :
 *
 *     延迟初始化
 *
 *     方案一：初始化为 null
 *     方案二：使用lateinit
 *     方案三：使用lazy （推荐）
 *
 *
 * </pre>
 */

// 初始化为 null
class TestActivity : AppCompatActivity() {
    private var nameView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameView = findViewById(R.id.tv_name)
        nameView?.text = "hello"
    }
}

// 使用lateinit
class Test2Activity : AppCompatActivity() {
    private lateinit var nameView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (::nameView.isInitialized) {
            nameView = findViewById(R.id.tv_name)
        }
        nameView.text = "hello"
    }
}

// 使用lazy
class Test3Activity : AppCompatActivity() {
    private val nameView by lazy {
        findViewById<TextView>(R.id.tv_name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameView.text = "hello"
    }
}