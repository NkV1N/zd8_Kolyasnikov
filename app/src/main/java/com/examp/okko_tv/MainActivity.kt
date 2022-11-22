package com.examp.okko_tv

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.math.log10

class MainActivity : AppCompatActivity(){
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var names: EditText
    lateinit var fam: EditText
    lateinit var email: EditText
    lateinit var shared: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login = findViewById(R.id.password)
        password = findViewById(R.id.double_password)
        names = findViewById(R.id.name)
        fam = findViewById(R.id.fam)
        email = findViewById(R.id.email)
        shared=getSharedPreferences("ACCOUNT_FILMS", MODE_PRIVATE)
        if(shared.contains("MY_LOGIN_FILM")){
            val log = shared.getString("MY_LOGIN_FILM", "NONE")
            names.setText(log)
        }
    }
    fun input(view: View){
        if(!shared.contains("MY_LOGIN_FILM")){
            if(login.text.toString().isNotEmpty() && login.text.toString().isNotEmpty() && login.text.toString().isNotEmpty()
                && fam.text.toString().isNotEmpty() && email.text.toString().isNotEmpty()){
                if(login.text.toString() == password.text.toString()){
                    var editing = shared.edit()
                    editing.putString("MY_LOGIN_FILM", names.text.toString())
                    editing.apply()
                    val intent = Intent(this, screen2::class.java)
                    startActivity(intent)
                }
                else{
                    val alter = AlertDialog.Builder(this)
                        .setTitle("Ошибка").setMessage("Пароли не совпадают").setPositiveButton("ОК", null).create().show()
                }
            }
            else{
                val after = AlertDialog.Builder(this)
                    .setTitle("Ошибка").setMessage("У Вас есть незаполненные поля").setPositiveButton("ОК", null).create().show()
            }
        }
        else{
            var type = shared.getString("MY_LOGIN_FILM", "NONE")
            if(type == names.toString()){
                val after = AlertDialog.Builder(this)
                    .setTitle("Ошибка").setMessage("Вы уже зарегистрированны").setPositiveButton("ОК", null).create().show()
                val intent = Intent(this, screen2::class.java)
                startActivity(intent)
            }
            else{
                if(login.text.toString().isNotEmpty() && login.text.toString().isNotEmpty() && login.text.toString().isNotEmpty()
                    && fam.text.toString().isNotEmpty() && email.text.toString().isNotEmpty()){
                    if(login.text.toString() == password.text.toString()){
                        var editing = shared.edit()
                        editing.putString("MY_LOGIN_FILM", names.text.toString())
                        editing.apply()
                        val intent = Intent(this, screen2::class.java)
                        startActivity(intent)
                    }
                    else{
                        val alter = AlertDialog.Builder(this)
                            .setTitle("Ошибка").setMessage("Пароли не совпадают").setPositiveButton("ОК", null).create().show()
                    }
                }
                else {
                    val after = AlertDialog.Builder(this)
                        .setTitle("Ошибка").setMessage("У Вас есть незаполненные поля")
                        .setPositiveButton("ОК", null).create().show()
                }
            }
        }
    }
}