package com.ahmed.groceriesapp.datasources.local.room

import android.content.Context
import androidx.room.Room
import com.ahmed.groceriesapp.model.user.User
import com.ahmed.groceriesapp.ui.screens.auth.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "localdb").build()
    }

    @Singleton
    @Provides
    fun providesUserDao(db: DataBase): UserDao {
        return db.getUserDao()
    }

    @Provides
    @Singleton
    fun providesUser(dao:UserDao): User {
        return dao.login("ahmed@ahmed.com","12345678")
    }
}