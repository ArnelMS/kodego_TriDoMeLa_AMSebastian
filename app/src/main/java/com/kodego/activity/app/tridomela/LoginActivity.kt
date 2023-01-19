package com.kodego.activity.app.tridomela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.activity.app.tridomela.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRegisterNow.setOnClickListener(){
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

    }
}