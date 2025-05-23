package com.klu.shoppingapp.core.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.klu.shoppingapp.core.notification.DailyShoppingNotifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShoppingAlarmReceiver : BroadcastReceiver() {

    @Inject
    lateinit var dailyShoppingNotifier: DailyShoppingNotifier

    override fun onReceive(context: Context?, p1: Intent?) {
        context?.let {
            dailyShoppingNotifier.launchNotification()
        }
    }
}