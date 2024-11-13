package com.example.lab7_retrofit.database.supermarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SupermarketItemDao {

    @Insert(onConflict = 1)
    fun insert(item: SupermarketItemEntity)

    @Delete
    fun delete(item: SupermarketItemEntity)

    @Update
    fun update(item: SupermarketItemEntity)

    @Query("SELECT * FROM supermarket_items")
    fun getAllItems(): Flow<List<SupermarketItemEntity>>
}