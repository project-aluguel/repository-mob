package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_wallet2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet2)
        // Esconde a barra de ação
        supportActionBar?.hide()
        buscaSaldo()
    }

    var idCarteira = ""

    fun buscaSaldo(){

        val valorCarteira = findViewById<TextView>(R.id.valorCarteira)
        val idUsuarioRecebido = intent.getStringExtra("idUser")
        val call = Apis.apiCarteira().buscaCarteira("e3e275af-0525-417f-933d-10d0e77f656b")

        call.enqueue(object : Callback<CarteiraUsuario> {
            override fun onResponse(
                call: Call<CarteiraUsuario>,
                response: Response<CarteiraUsuario>
            ) {
                if (response.isSuccessful){
                    idCarteira = response.body()?.idCarteira.toString()
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

    fun recargaCarteira(component: View){

        val recarga = findViewById<EditText>(R.id.recarga)
        val call = Apis.apiCarteira().recarregaCarteira(idCarteira, RecargaCarteira(recarga.toString().toDouble()))

        call.enqueue(object : Callback<CarteiraUsuario>{

            override fun onResponse(
                call: Call<CarteiraUsuario>,
                response: Response<CarteiraUsuario>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
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