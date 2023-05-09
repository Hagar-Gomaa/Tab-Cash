package com.example.tabcash

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
@BindingAdapter("error")
fun bindErrorOnTextInputLayout(
    textInputLayout: TextInputLayout,
    errorMessage :String?){
    textInputLayout.error =errorMessage
}