package com.ahmed.groceriesapp.model.resourec
sealed class Resource<out T>{
    object Loading:Resource<Nothing>()
    class Error(val errorCode:Int):Resource<Nothing>()
    class Success<out T>(val data: T?):Resource<T>()
    object Init:Resource<Nothing>()
}