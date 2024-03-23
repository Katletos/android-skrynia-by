package com.example.lab.auth.state

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.lab.MainActivity

data class Credentials(
    var login: String = "",
    var pwd: String = "",
    var remember: Boolean = false
) {
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty() && pwd.isNotEmpty()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
fun checkCredentials(credentials: Credentials, context: Context): Boolean {
    if (credentials.isNotEmpty() && credentials.login == "admin") {
        context.startActivity(Intent(context, MainActivity::class.java))
        (context as Activity).finish()
        return true
    } else {
        Toast.makeText(context, "Wrong Credentials", Toast.LENGTH_SHORT).show()
        return false
    }
}