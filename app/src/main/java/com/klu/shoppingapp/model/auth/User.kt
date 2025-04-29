package com.klu.shoppingapp.model.auth

data class User(
    val uid: Long,
    val name: String? = null,
    val email: String,
    val photoUrl: String? = null,
    val emailVerified: Boolean
)