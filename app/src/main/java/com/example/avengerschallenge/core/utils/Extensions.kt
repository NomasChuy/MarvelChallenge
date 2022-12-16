package com.example.avengerschallenge.core.utils

import android.view.View
import android.widget.Button
import android.widget.TextView

fun TextView.setTextVisibility(txt: String){
    text = txt
    visibility = if(txt.isBlank()) View.GONE else View.VISIBLE
}

fun Button.setButtonVisibility(btnTextList: List<String>){
    visibility = if(btnTextList.isEmpty()) View.GONE else View.VISIBLE
}

fun Button.setButtonVisibility(btnText: String){
    visibility = if(btnText.isBlank()) View.GONE else View.VISIBLE
}