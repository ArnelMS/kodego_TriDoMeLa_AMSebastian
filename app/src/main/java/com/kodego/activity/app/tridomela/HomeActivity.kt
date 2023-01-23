package com.kodego.activity.app.tridomela

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodego.activity.app.tridomela.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentOne = FragmentOne()
        val fragmentTwo = FragmentTwo()
        val fragmentThree = FragmentThree()
        val fragmentFour = FragmentFour()
        val fragmentFive = FragmentFive()

        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentMain.id,fragmentOne)
            commit()
        }
        binding.btnFragment1.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id,fragmentOne)
                commit()
            }
        }
        binding.btnFragment2.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id,fragmentTwo)
                commit()
            }
        }
        binding.btnFragment3.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.fragmentMain.id,fragmentThree)
                commit()
            }
        }

    }
}