package com.ahmed.groceriesapp.model.resourec

data class Resource<out T>(val status: Status, val data: T?,val errorCode: Int = 0) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data
            )
        }

        fun <T> error(errorCode:Int,data:T? =null): Resource<T> {
            return Resource(
                Status.ERROR,
                errorCode = errorCode,
                data = null

            )
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(
                Status.LOADING,
                data = null
            )
        }
        fun <T> init(): Resource<T> {
            return Resource(
                Status.INIT,
                null
            )
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        INIT
    }
}