package com.example.listacompras2

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class CadastroActivity : AppCompatActivity() {
    val	COD_IMAGE	=	101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val txt_produto = findViewById<EditText>(R.id.txt_produto)

        val txt_qtd = findViewById<EditText>(R.id.txt_qtd)
        val txt_valor = findViewById<EditText>(R.id.txt_valor)

        val img_foto_produto = findViewById<ImageView>(R.id.img_foto_produto)


        img_foto_produto.setOnClickListener	{
            abrirGaleria()
        }
        //definição	do	ouvinte	do	botão
        btn_inserir.setOnClickListener	{
            //pegando	os	valores	digitados	pelo	usuário
            val	produto	=	txt_produto.text.toString()
            val	qtd	=	txt_qtd.text.toString()
            val	valor	=	txt_valor.text.toString()

            

            //verificando	se	o	usuário	digitou	algum	valor
            if	(produto.isNotEmpty()	&&	qtd.isNotEmpty()		&&	valor.isNotEmpty())	{
                val imageBitMap = (img_foto_produto.drawable as BitmapDrawable).bitmap
                //val	prod	=	Produto(produto,	qtd.toInt(),	valor.toDouble())
                val	prod	=	Produto(produto, qtd.toInt(), valor.toDouble(),	imageBitMap)
                produtosGlobal.add(prod)
                txt_produto.text.clear()
                txt_qtd.text.clear()
                txt_valor.text.clear()
            }else{
                txt_produto.error	=	if	(txt_produto.text.isEmpty()) "Preencha	o	nome	do	produto"	else	null
                txt_qtd.error	=	if	(txt_qtd.text.isEmpty())	"Preencha	a	quantidade"	else	null
                txt_valor.error	=	if	(txt_valor.text.isEmpty())	"Preencha o	valor"	else	null
            }

        }
    }

    override	fun	onActivityResult(requestCode:	Int,	resultCode:	Int,
                                        data:	Intent?)	{
        super.onActivityResult(requestCode,	resultCode,	data)
        if	(requestCode	==	COD_IMAGE	&&	resultCode	==	Activity.RESULT_OK)	{
            if	(data	!=	null)	{
                //lendo	a	uri	com	a	imagem
                val	inputStream	=	contentResolver.openInputStream(data.getData()!!);
                //transformando	o	resultado	em	bitmap
                val imageBitMap	=	BitmapFactory.decodeStream(inputStream)
                //Exibir	a	imagem	no	aplicativo
                val img_foto_produto = findViewById<ImageView>(R.id.img_foto_produto)
                img_foto_produto.setImageBitmap(imageBitMap)
            }
        }
    }

    fun	abrirGaleria(){
        //definindo	a	ação	de	conteúdo
        val	intent	=	Intent(Intent.ACTION_GET_CONTENT)
        //definindo	filtro	para	imagens
        intent.type	=	"image/*"
        //inicializando	a	activity	com	resultado
        startActivityForResult(Intent.createChooser(intent,	"Selecione	uma	imagem"),	COD_IMAGE)
    }
}