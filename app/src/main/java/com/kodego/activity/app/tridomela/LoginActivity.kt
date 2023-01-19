package com.kodego.activity.app.tridomela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kodego.activity.app.tridomela.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.tvRegisterNow.setOnClickListener(){
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Please fill up all details!", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogin.setOnClickListener(){
            performLogin()
        }
    }

    private fun performLogin() {
        if (binding.etUsernameEmail.text.toString().isEmpty() || binding.etPassword.text.toString()
                .isEmpty()
        ) {
            Toast.makeText(applicationContext, "Please fill up all fields!", Toast.LENGTH_SHORT)
                .show()
            return
        }

        auth.signInWithEmailAndPassword(
            binding.etUsernameEmail.text.toString(),
            binding.etPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, navigate to the MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Successfully created new account!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(applicationContext, "Authentication failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Authentication failed!", Toast.LENGTH_SHORT)
                    .show()
            }
    }
}