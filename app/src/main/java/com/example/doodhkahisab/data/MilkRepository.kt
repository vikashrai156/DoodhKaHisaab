package com.example.doodhkahisab.data

import android.content.Context
import com.example.doodhkahisab.util.PricePreferences
import kotlinx.coroutines.flow.Flow

class MilkRepository(private val dao: MilkDao, private val prefs: PricePreferences) {

    fun getEntriesBetween(start: Long, end: Long): Flow<List<MilkEntry>> {
        return dao.getEntriesBetween(start, end)
    }

    suspend fun insertEntry(context: Context, dateMillis: Long, litres: Double) {
        val price = prefs.getDefaultPrice()
        val entry = MilkEntry(dateMillis = dateMillis, litres = litres, pricePerLitre = price)
        dao.insert(entry)
    }

    suspend fun getTotalLitres(start: Long, end: Long): Double {
        return dao.getTotalLitresBetween(start, end) ?: 0.0
    }
}
