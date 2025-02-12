package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menangani klik tombol login
        binding.loginButton.setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        val username = binding.usernameEditText.text.toString().trim()
        val password = binding.passwordEditText.text.toString().trim()

        // Validasi input
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username dan Password harus diisi!", Toast.LENGTH_SHORT).show()
            return
        }

        // Autentikasi sederhana (ganti dengan autentikasi dari database jika diperlukan)
        if (username == "gania" && password == "1234") {
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

            // Pindah ke halaman utama (MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup halaman login agar tidak bisa kembali ke sini
        } else {
            Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
        }
    }
}