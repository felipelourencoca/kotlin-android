package com.example.listaaplicativos2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_adicionar = findViewById<Button>(R.id.btn_adicionar)
        btn_adicionar.setOnClickListener{
            //Criando	a	Intent	explícita
            val	intent	=	Intent(this,CadastroActivity::class.java)
            //iniciando	a	atividade
            startActivity(intent)
        }


    }
}