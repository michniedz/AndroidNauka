package com.example.android3kotlin

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3kotlin.adapters.ContactsAdapter
import com.example.android3kotlin.data.Contact
import com.example.android3kotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val c1 = Contact("John", "Smith", "123456789")
        val c2 = Contact("Jan", "Smith", "456798132")
        val c3 = Contact("Jen", "Smith", "78945613")
        val contactList = listOf(c1, c2, c3, c1, c2, c3, c1, c2, c3, c1, c2, c3)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter =
            ContactsAdapter(contactsList = contactList,
                callListener = {
                    Toast.makeText(applicationContext, "Call to number: $it", Toast.LENGTH_SHORT).show()
                },
                smsListener = {
                    Toast.makeText(applicationContext, "Send sms to: $it", Toast.LENGTH_SHORT).show()
                })
    }
}