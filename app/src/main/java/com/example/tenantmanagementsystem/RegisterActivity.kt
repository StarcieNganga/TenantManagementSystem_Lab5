package com.example.tenantmanagementsystem

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerSubmitButton.setOnClickListener {
            val email = binding.registerEmailEditText.text.toString()

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("USER_EMAIL", email)
            }
            startActivity(intent)
            finish()
        }
    }
}