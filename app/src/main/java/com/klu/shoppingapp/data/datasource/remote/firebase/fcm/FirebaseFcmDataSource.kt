package com.klu.shoppingapp.data.datasource.remote.firebase.fcm

import com.google.android.gms.tasks.Task

interface FirebaseFcmDataSource {

    fun getFCMToken(): Task<String>
}