package com.example.tugas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tugas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tv: TextView
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnFragment1: Button
    private lateinit var btnFragment2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnFragment1 = binding.btnFragment1
        btnFragment1.setOnClickListener { replaceFragment(BlankFragment1()) }

        btnFragment2 = binding.btnFragment2
        btnFragment2.setOnClickListener { replaceFragment(BlankFragment2()) }

        val usernamee = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username: $usernamee dan password: $password"

        val btnImplisit: Button = findViewById(R.id.btn_implicit)
        btnImplisit.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_implicit -> {
                val message = "halo bang"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,message)
                intent.type = "text/plain"
                startActivity(intent)

//                val intent = Intent()
//                intent.putExtra("history", "anda sudah pernah login")
//                setResult(RESULT_OK,intent)
//                finish()
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view_tag, fragment)
        fragmentTransaction.commit()
    }
}