package com.kodego.activity.app.tridomela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kodego.activity.app.tridomela.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegistrationBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.tvLoginNow.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener(){
            performSignUp()

        }

    }

    private fun performSignUp() {
//        binding.etUsernameEmailRegister.text.toString()
//        binding.etPasswordRegister.text.toString()

        if(binding.etUsernameEmailRegister.text.isEmpty() || binding.etPasswordRegister.text.isEmpty()){
            Toast.makeText(applicationContext,"Please fill-up all fields!", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(
            binding.etUsernameEmailRegister.text.toString(),
            binding.etPasswordRegister.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(applicationContext,"Successfully created new account!", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(applicationContext,"Authentication failed!", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener{
                Toast.makeText(applicationContext,"Error occured!", Toast.LENGTH_SHORT).show()
            }
    }
}