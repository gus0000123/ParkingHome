package com.hyun.parkinghome.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Query("SELECT * FROM CarEntity")
    fun selectAll(): Flow<List<CarEntity>>

    @Insert
    fun insert(carEntity: CarEntity)
}