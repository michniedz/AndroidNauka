package com.example.android3kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.commit
import com.example.android3kotlin.databinding.ActivityMainBinding
import com.example.android3kotlin.fragmenty.FirstFragment
import com.example.android3kotlin.fragmenty.SecondFragment
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private  var wartosc = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            addToBackStack("INIT_COMMIT")
//            add(R.id.FirstFragment, firstFragment)
//            add(R.id.SecondFragment, secondFragment)
//        }
        binding.FirstFragment.setOnClickListener {
            if(!supportFragmentManager.fragments.contains(firstFragment)){
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack("FIRST")
                    add(R.id.FirstFragment, firstFragment)
                }
            }

        }
    binding.SecondFragment.setOnClickListener {
        if(!supportFragmentManager.fragments.contains(secondFragment)){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack("SECOND")
                add(R.id.SecondFragment, secondFragment)
            }
        }
    }
//        supportFragmentManager.beginTransaction()
//        if (savedInstanceState != null){
//            val mWartosc = savedInstanceState.getInt("VALUE")
//            wartosc = mWartosc
//            binding.licz.text = wartosc.toString()
//        }
//        binding.przycisk1.setOnClickListener{
//            val rand = Random.nextInt(0,100)
//            wartosc = rand
//            binding.licz.text = wartosc.toString()
//        }
//        binding.przycisk1.setOnClickListener{
//            Toast.makeText(applicationContext, binding.imie.text.toString(), Toast.LENGTH_SHORT).show()
//            binding.licz.text = binding.licz.text + 1
//            val intent = Intent(Intent.ACTION_SENDTO)
//            val data = binding.imie.text.toString()
//            intent.data = "sms:$data".toUri()
//            val intentWithChooser = Intent.createChooser(intent, "Wybierz aplikację do dzwoniania")
//            intent.putExtra("MY_DATA", data)
//            startActivity(intentWithChooser)
//        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("VALUE", wartosc)
//    }
}