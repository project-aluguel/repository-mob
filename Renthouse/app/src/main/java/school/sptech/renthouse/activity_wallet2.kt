package school.sptech.renthouse

import android.content.Context
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
        buscaSaldo("fc453727-5bad-438c-a1f0-76020a90416b")
    }
    fun goToCarteira(view: View?) {
        val intent = Intent(this, activity_wallet::class.java)
        startActivity(intent)
    }

    public fun goToRechargeWallet(componente: View) {
        val homeActivity = Intent(this, HomeActivity::class.java)
        recargaCarteira(componente.context, homeActivity)
    }


    fun buscaSaldo(id: String){

        val valorCarteira = findViewById<TextView>(R.id.valorCarteira)
        val call = Apis.apiCarteira().buscaCarteira(id)

        call.enqueue(object : Callback<CarteiraUsuario> {
            override fun onResponse(
                call: Call<CarteiraUsuario>,
                response: Response<CarteiraUsuario>
            ) {
                if (response.isSuccessful){

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

    fun recargaCarteira(context: Context, mainActivity: Intent) {

        val recarga = findViewById<EditText>(R.id.recarga)
        val recargaValue = recarga.text.toString().toDoubleOrNull()

        if (recargaValue != null) {
            val call =
                Apis.apiCarteira().recarregaCarteira("e5916c49-001b-46dd-9127-acc1a2a3961e", RecargaCarteira(recargaValue))

            call.enqueue(object : Callback<CarteiraUsuario> {
                override fun onResponse(
                    call: Call<CarteiraUsuario>,
                    response: Response<CarteiraUsuario>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            finish();
                            overridePendingTransition(0, 0);
                            context.startActivity(mainActivity);
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
}