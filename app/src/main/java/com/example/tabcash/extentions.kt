package com.example.tabcash


fun String.isValidEmail():Boolean{
    if(isNullOrBlank())return false
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches();
}
fun String.isValidPhone():Boolean{
    if(isNullOrBlank())return false
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches();
}