package com.klu.shoppingapp.common.caller

import android.util.Log
import com.klu.shoppingapp.R
import com.klu.shoppingapp.common.Response

suspend inline fun <T> dbCall(crossinline call: suspend () -> T): Response<T> {
    return try {
        Response.Success(data = call())
    } catch (e: Exception) {
        Log.d("DB CALL EXCEPTION", e.stackTraceToString())
        Response.Error(errorMessageId = R.string.unknown_error)
    }
}