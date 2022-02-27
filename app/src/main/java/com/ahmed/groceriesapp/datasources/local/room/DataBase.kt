package com.ahmed.groceriesapp.datasources.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmed.groceriesapp.model.user.User
import com.ahmed.groceriesapp.ui.screens.auth.data.local.UserDao

@Database(entities = [User::class],version = 1)
abstract class DataBase:RoomDatabase() {
    abstract fun getUserDao() : UserDao
}