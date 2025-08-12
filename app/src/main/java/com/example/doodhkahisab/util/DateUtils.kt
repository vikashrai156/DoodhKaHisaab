package com.example.doodhkahisab.util

import java.util.*

object DateUtils {
    fun startOfMonthMillis(year:Int, monthZeroBased:Int): Long {
        val cal = Calendar.getInstance()
        cal.clear()
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, monthZeroBased)
        cal.set(Calendar.DAY_OF_MONTH, 1)
        return cal.timeInMillis
    }
    fun endOfMonthMillis(year:Int, monthZeroBased:Int): Long {
        val cal = Calendar.getInstance()
        cal.clear()
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, monthZeroBased)
        val last = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        cal.set(Calendar.DAY_OF_MONTH, last)
        cal.set(Calendar.HOUR_OF_DAY,23)
        cal.set(Calendar.MINUTE,59)
        cal.set(Calendar.SECOND,59)
        return cal.timeInMillis
    }
    fun currentMonthRange(): Pair<Long, Long> {
        val c = Calendar.getInstance()
        val y = c.get(Calendar.YEAR)
        val m = c.get(Calendar.MONTH)
        return startOfMonthMillis(y,m) to endOfMonthMillis(y,m)
    }
}
