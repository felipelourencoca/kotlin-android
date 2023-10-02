package com.example.listaaplicativos2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //definição	do	ouvinte	do	botão
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val txt_produto = findViewById<EditText>(R.id.txt_produto)

        btn_inserir.setOnClickListener	{//pegando	o	valor	digitado	pelo	usuário
            val	produto	=	txt_produto.text.toString()
            if	(produto.isNotEmpty())	{
                //enviado	o	item	para	a	lista
                //limpando	a	caixa	de	texto
                txt_produto.text.clear()
            }else{
                txt_produto.error	=	"Preencha	um	valor"
            }
        }
    }
}