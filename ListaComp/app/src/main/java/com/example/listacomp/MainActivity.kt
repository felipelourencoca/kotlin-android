package com.example.listacomp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override	fun	onCreate(savedInstanceState:	Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Implementação	do	adaptador
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        //definindo	o	adaptador	na	lista
        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)
        list_view_produtos.adapter = produtosAdapter
        //definição	do	ouvinte	do	botão

        //pegando elementos das views
        val txt_produto = findViewById<EditText>(R.id.txt_produto)
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        btn_inserir.setOnClickListener {
            //pegando	o	valor	digitado	pelo	usuário

            val produto = txt_produto.text.toString()
            if (produto.isNotEmpty()) {
                //enviado	o	item	para	a	lista
                produtosAdapter.add(produto)
                //limpando	a	caixa	de	texto
                txt_produto.text.clear()
            } else {
                val txt_produto = findViewById<EditText>(R.id.txt_produto)
            }
        }
        list_view_produtos.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            //buscando	o	item	clicado
            val item = produtosAdapter.getItem(position)
            //removendo	o	item	clicado	da	lista
            produtosAdapter.remove(item)
            //retorno	indicando	que	o	click	foi	realizado	com	suc     esso
            true
        }
    }
}