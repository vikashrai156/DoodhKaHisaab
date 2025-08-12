package com.example.doodhkahisab.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MilkDao {
    @Insert
    suspend fun insert(entry: MilkEntry): Long

    @Query("SELECT * FROM milk_entries WHERE dateMillis BETWEEN :start AND :end ORDER BY dateMillis ASC")
    fun getEntriesBetween(start: Long, end: Long): Flow<List<MilkEntry>>

    @Query("SELECT SUM(litres) FROM milk_entries WHERE dateMillis BETWEEN :start AND :end")
    suspend fun getTotalLitresBetween(start: Long, end: Long): Double?
}
