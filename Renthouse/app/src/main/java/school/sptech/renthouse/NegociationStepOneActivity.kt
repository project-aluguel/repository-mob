package school.sptech.renthouse

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NegociationStepOneActivity : AppCompatActivity() {
    val itemNome = SessaoItem.titulo
    val itemValor = SessaoItem.valorItem
    val itemFoto = SessaoItem.foto
    val itemDescricao = SessaoItem.descricao
    val idProprietario = SessaoItem.idProprietario
    val idItem = SessaoItem.idItem;
    val idUsuarioNegociacao = SessaoUsuario.usuario.id
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_negociation_step_one)
        // Esconde a barra de ação
        supportActionBar?.hide()




        println("------------------------- nome, " + itemNome)
        println("------------------------- VALOR, " + itemValor)
        println("------------------------- Foto, " + itemFoto)
        println("------------------------- Foto, " + itemDescricao)
        println("------------------------- Foto, " + idProprietario)
        println("------------------------- idUsuariosooooooo, " + idUsuarioNegociacao)
        println("------------------------- Foto, " + idItem)


        val titleNegociation = findViewById<TextView>(R.id.titulo_negociacao)
        val valorItemNegociacao = findViewById<TextView>(R.id.valor_negociacao)
        val imgView = findViewById<ImageView>(R.id.img_negociacao)
        val descricaoNegociacao = findViewById<TextView>(R.id.descricao_negociacao)
        val imgUrl = itemFoto

        titleNegociation?.text = itemNome
        descricaoNegociacao?.text = itemDescricao
        valorItemNegociacao?.text = itemValor.toString()
        println("imagem vem assim, " + imgUrl)
        Glide.with(this).load(imgUrl).into(imgView);
    }
    fun goToPerfil(view: View?) {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("SuspiciousIndentation")
    fun goToNext(view: View?) {

        val apiItens = Apis.getApiItens();


       val dataNegociationRequest = NegociationRequest("2023/06/10","2023/07/10",itemValor,
      0.0,idItem,idProprietario, idUsuarioNegociacao);

      val negociation =  apiItens.negociacaoItens(dataNegociationRequest);

        negociation.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("Funcionouuuuuuuuu ")

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("Deu erroooor "+ t.message)
            }

        })

    }
}