package com.example.doodhkahisab.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.doodhkahisab.databinding.ActivityMainBinding
import com.example.doodhkahisab.util.DateUtils
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels { MainViewModel.Factory(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val litresText = binding.etLitres.text.toString()
            if (litresText.isBlank()) {
                Toast.makeText(this, "Please enter litres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val litres = litresText.toDoubleOrNull() ?: 0.0
            val today = Date().time
            vm.addEntry(litres, today)
            binding.etLitres.text?.clear()
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

        // Observe monthly totals (current month)
        val (start, end) = DateUtils.currentMonthRange()
        vm.getEntriesForRange(start, end).observe(this) { list ->
            binding.tvSummary.text = "Entries: ${list.size}\nTotal litres: ${list.sumOf { it.litres }}"
        }

        binding.btnSettings.setOnClickListener {
            startActivity(android.content.Intent(this, SettingsActivity::class.java))
        }
    }
}
