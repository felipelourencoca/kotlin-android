package com.example.listacompras2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        produtosGlobal.add(Produto("aaa", 1, 1.0,null))

        val btn_adicionar = findViewById<Button>(R.id.btn_adicionar)
        btn_adicionar.setOnClickListener	{
            //Criando	a	Intent	explícita
            val	intent	=	Intent(this,	CadastroActivity::class.java)
            //iniciando	a	atividade
            startActivity(intent)
        }
    }

    override fun onResume()	{
        super.onResume()
        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)

        val	adapter	=	list_view_produtos.adapter as? ProdutoAdapter


        adapter?.let {
            it.clear()
            it.addAll(produtosGlobal)
        }


        val	soma	=	produtosGlobal.sumByDouble	{	it.valor	*	it.quantidade	}
        val	f	=	NumberFormat.getCurrencyInstance(Locale("pt",	"br"))

        val txt_total = findViewById<TextView>(R.id.txt_total)
        txt_total.text	=	"TOTAL:	${	f.format(soma)}"


    }
}