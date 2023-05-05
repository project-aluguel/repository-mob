package school.sptech.renthouse

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_wallet : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        // Esconde a barra de ação
        supportActionBar?.hide()

      val userId =  SessaoUsuario.usuario.id;
        val nomeUsuario = SessaoUsuario.usuario.nomeCompleto //
        val nomeUsuarioTextView = findViewById<TextView>(R.id.nameUser_wallet)
        nomeUsuarioTextView.text = "Olá $nomeUsuario você possui"
        buscaSaldo(userId)
    }

    fun buscaSaldo(idUsuario: String){

        val valorCarteira = findViewById<TextView>(R.id.valorCarteira)
        val call = Apis.apiCarteira().buscaCarteira(idUsuario)

        call.enqueue(object : Callback<CarteiraUsuario> {
            override fun onResponse(
                call: Call<CarteiraUsuario>,
                response: Response<CarteiraUsuario>
            ) {
                if (response.isSuccessful){
                    println("Saldo do carteira ----, " + response.body()?.saldoCarteira.toString())
                    response.body()?.let {
                        valorCarteira.text = it.saldoCarteira.toString()
                    }
                }
            }
            override fun onFailure(call: Call<CarteiraUsuario>, t: Throwable) {
                println(" -----------------------------------------" + t.message)
                t.printStackTrace()
            }
        })
    }

    fun goToWallet2(view: View?) {
        val intent = Intent(this, activity_wallet2::class.java)
        startActivity(intent)
    }
    fun goToPerfil(view: View?) {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
    }

}