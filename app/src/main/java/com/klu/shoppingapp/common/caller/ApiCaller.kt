package com.klu.shoppingapp.common.caller

import android.util.Log
import com.klu.shoppingapp.R
import com.klu.shoppingapp.common.Response
import java.io.IOException

suspend inline fun <T> apiCall(crossinline call: suspend () -> T): Response<T> {
    return try {
        Response.Success(data = call())
    } catch (e: IOException) {
        Response.Error(errorMessageId = R.string.network)
    } catch (e: Exception) {
        Log.d("API CALL EXCEPTION", e.message.toString())
        Response.Error(errorMessageId = R.string.unknown_error)
    }
}