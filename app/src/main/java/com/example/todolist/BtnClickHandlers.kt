package com.example.todolist


import android.widget.Toast
import com.example.todolist.databinding.ActivityMainBinding

class BtnClickHandlers {
    fun onShowMyNameBtnHandle(user: User) {

        val text = user.firstName
        val duration = Toast.LENGTH_SHORT
        //Toast.makeText(this, text, duration).show()
    }

}