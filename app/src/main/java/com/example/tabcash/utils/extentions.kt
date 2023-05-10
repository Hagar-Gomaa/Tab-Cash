package com.example.tabcash

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


fun String.isValidEmail():Boolean{
    if(isNullOrBlank())return false
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches();
}
fun Fragment.naviagte(view: View, action: Int) {
    Navigation.findNavController(view).navigate(action)
}