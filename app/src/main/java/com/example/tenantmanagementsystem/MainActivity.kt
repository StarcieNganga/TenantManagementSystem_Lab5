package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receive email passed from RegisterActivity
        val userEmail = intent.getStringExtra("USER_EMAIL")
        if (!userEmail.isNullOrEmpty()) {
            Toast.makeText(this, "Welcome $userEmail", Toast.LENGTH_SHORT).show()
        }

        // SAVE button logic
        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val rent = binding.rentEditText.text.toString()

            val tenant = Tenant(name, phone, rent)
            binding.tenant = tenant
        }

        // CALL SUPPORT button logic
        binding.callButton.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:0700000000")
            }
            startActivity(dialIntent)
        }
    }
}