package com.ahmed.groceriesapp.ui.screens.auth.data.di

import com.ahmed.groceriesapp.model.user.User
import com.ahmed.groceriesapp.ui.screens.auth.data.local.UserDao
import com.ahmed.groceriesapp.ui.screens.auth.data.local.UserLocalDataDataSourceImpl
import com.ahmed.groceriesapp.ui.screens.auth.data.local.UserLocalDataSource
import com.ahmed.groceriesapp.ui.screens.auth.domain.AuthRepository
import com.ahmed.groceriesapp.ui.screens.auth.domain.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule{
    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindUserLocal(
        userLocalDataDataSourceImpl: UserLocalDataDataSourceImpl
    ):UserLocalDataSource


}

