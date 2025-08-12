package com.example.doodhkahisab.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doodhkahisab.databinding.ActivitySettingsBinding
import com.example.doodhkahisab.util.PricePreferences

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var prefs: PricePreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = PricePreferences(this)
        val cur = prefs.getDefaultPrice()
        binding.etPrice.setText(if (cur>0) cur.toString() else "")
        binding.btnSave.setOnClickListener {
            val v = binding.etPrice.text.toString().toDoubleOrNull() ?: 0.0
            prefs.setDefaultPrice(v)
            finish()
        }
    }
}
