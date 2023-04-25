package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_wallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        // Esconde a barra de ação
        supportActionBar?.hide()
        buscaSaldo()
    }

    fun buscaSaldo(){

        val valorCarteira = findViewById<TextView>(R.id.valorCarteira)
        val idUsuarioRecebido = intent.getStringExtra("idUsuario")
        println(idUsuarioRecebido)
        val call = Apis.apiCarteira().buscaCarteira("e3e275af-0525-417f-933d-10d0e77f656b")

        call.enqueue(object : Callback<CarteiraUsuario> {
            override fun onResponse(
                call: Call<CarteiraUsuario>,
                response: Response<CarteiraUsuario>
            ) {
                if (response.isSuccessful){
                    val idCarteira = response.body()?.idCarteira.toString()
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

}