package com.ahmed.groceriesapp.ui.screens.auth.data.local

import com.ahmed.groceriesapp.model.user.User
import javax.inject.Inject

interface UserLocalDataSource {
    suspend fun register(user:User)
    suspend fun login(email:String,password:String):User
}


class UserLocalDataDataSourceImpl @Inject constructor(private val dao:UserDao) : UserLocalDataSource{
    override suspend fun register(user: User) {
       return dao.register(user = user)
    }

    override suspend fun login(email: String, password: String): User {
        return dao.login(email = email,password = password)
    }

}