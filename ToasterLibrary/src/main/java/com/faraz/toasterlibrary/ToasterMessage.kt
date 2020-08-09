package com.faraz.toasterlibrary

import android.content.Context
import android.widget.Toast

class ToasterMessage {

    fun shiri(c: Context?, message: String?) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    }

    fun shiriNew(c: Context?, message: String?) {
        Toast.makeText(c, message, Toast.LENGTH_LONG).show()
    }
}