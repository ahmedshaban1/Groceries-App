package com.ahmed.groceriesapp.ui.screens.auth.domain

import com.ahmed.groceriesapp.bases.BaseUseCase
import com.ahmed.groceriesapp.bases.ResultWrapper
import com.ahmed.groceriesapp.model.resourec.Resource
import com.ahmed.groceriesapp.model.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class UserLoginUserCase @Inject constructor(private val repository: AuthRepository) :
    BaseUseCase() {
    suspend operator fun invoke(email:String,password:String): Flow<Resource<User>> {
        return flow {
            when (val data = makeLocalRequest {repository.login(email = email, password = password)}){
                is ResultWrapper.Success->{
                    emit(Resource.Success(data = data.value))
                }
                is ResultWrapper.GenericError -> {
                    emit(Resource.Error(errorCode = data.errorCode))
                }
            }
        }.onStart {
            emit(Resource.Loading)
        }
    }
}

