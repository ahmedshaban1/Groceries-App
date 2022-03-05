package com.ahmed.groceriesapp.ui.screens.auth.domain

import com.ahmed.groceriesapp.model.user.User
import com.ahmed.groceriesapp.ui.screens.auth.data.local.UserLocalDataSource
import javax.inject.Inject

interface AuthRepository {
    suspend fun register(user:User)
    suspend fun login(email:String,password:String): User?
}

class AuthRepositoryImpl @Inject constructor(private val local:UserLocalDataSource): AuthRepository{
    override suspend fun register(user: User) {
        local.register(user = user)
    }

    override suspend fun login(email: String, password: String): User {
        return local.login(email = email,password = password)
    }

}