package com.example.doodhkahisab.util

import android.content.Context

class PricePreferences(context: Context) {
    private val prefs = context.getSharedPreferences("doodh_prefs", Context.MODE_PRIVATE)
    fun getDefaultPrice(): Double = prefs.getFloat("default_price", 0f).toDouble()
    fun setDefaultPrice(price: Double) {
        prefs.edit().putFloat("default_price", price.toFloat()).apply()
    }
}
