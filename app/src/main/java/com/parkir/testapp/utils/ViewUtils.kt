package com.parkir.testapp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

//reified untuk membuat parameter tipe class
inline fun <reified T> Context.intentfinish() {
    val activity: Activity = this as Activity
    activity.finish()
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

inline fun <reified T> Context.intent() {
    val activity:Activity = this as Activity
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}