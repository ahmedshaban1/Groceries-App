package com.ahmed.groceriesapp.ui.screens.auth.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmed.groceriesapp.model.user.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("select * from user where email=:email and password=:password")
    fun login(email:String,password:String) : Flow<User>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun register(user: User) : Long

}