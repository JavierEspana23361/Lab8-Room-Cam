package com.example.lab7_retrofit.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab7_retrofit.database.supermarket.SupermarketItemDao
import com.example.lab7_retrofit.database.supermarket.SupermarketItemEntity

@Database(entities = [SupermarketItemEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun supermarketItemDao(): SupermarketItemDao
}