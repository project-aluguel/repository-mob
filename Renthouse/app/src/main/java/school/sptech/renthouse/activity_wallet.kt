package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        buscaSaldo("9c72f13f-2d15-49f3-8e3a-7ccf5ab78a54")
    }

    fun buscaSaldo(id:String){

        val valorCarteira = findViewById<TextView>(R.id.valorCarteira)
        val idUsuarioRecebido = intent.getStringExtra("idUser")
        val call = Apis.apiCarteira().buscaCarteira(idUsuarioRecebido.toString())

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
}