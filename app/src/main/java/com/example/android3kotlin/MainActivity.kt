package com.example.android3kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.net.toUri
import com.example.android3kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.przycisk1.setOnClickListener{
//            Toast.makeText(applicationContext, binding.imie.text.toString(), Toast.LENGTH_SHORT).show()
            //binding.licz.text = binding.licz.text + 1
            val intent = Intent(Intent.ACTION_SENDTO)
            val data = binding.imie.text.toString()
            intent.data = "sms:$data".toUri()
            val intentWithChooser = Intent.createChooser(intent, "Wybierz aplikację do dzwoniania")
            intent.putExtra("MY_DATA", data)
            startActivity(intentWithChooser)
        }

    }
}