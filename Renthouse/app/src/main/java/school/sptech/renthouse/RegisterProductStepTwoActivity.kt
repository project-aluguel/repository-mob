package school.sptech.renthouse

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.annotation.RequiresApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegisterProductStepTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_product_step_two)
    }




    @RequiresApi(Build.VERSION_CODES.O)
    fun cadastrar(componente: View) {

        val homeActivity = Intent(applicationContext, HomeActivity::class.java)

        verificarCadastro(componente.context, homeActivity)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun verificarCadastro(context: Context, homeActivity: Intent) {

        val etValorDia = findViewById<EditText>(R.id.valor_diario)
        val etValorMulta = findViewById<EditText>(R.id.valor_multa)
        val categoria = "games";
        val checkEntrega: CheckBox = findViewById(R.id.retirada_entrega)
        val checkPessoal: CheckBox  = findViewById(R.id.apenas_entrega)
        val tituloItem = SessaoItem.titulo;
        val foto = SessaoItem.foto;
        val descricaoItem = SessaoItem.descricao;
        val detalhesUso = SessaoItem.detalhesUso

        val CheckEntregaBoolean: Boolean = checkEntrega.isChecked
        val CheckPessoalBoolean: Boolean = checkPessoal.isChecked

        val etDataInicio = findViewById<EditText>(R.id.data_inicio);
        val dataInicioString = etDataInicio.text.toString()
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        val dataInicioItem = LocalDate.parse(dataInicioString, formatter)
        // agora você pode usar a data formatada como quiser
        val dataInicioFormatada = dataInicioItem.format(formatter)

        val etDataFim = findViewById<EditText>(R.id.data_fim)
        val dataFimString = etDataFim.text.toString()
        val formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        val dataFimItem = LocalDate.parse(dataFimString, formatter2)
        val dataFimFormatada = dataFimItem.format(formatter2)


        val valorMultaString = etValorMulta.text.toString()
        val valorMultaDouble: Double = valorMultaString.toDouble()

        val valorDiaString = etValorDia.text.toString()
        val valorDiaDouble: Double = valorDiaString.toDouble()
        val idUsuarioss = "3af4317d-3380-41c9-9427-021a0e4f0e96"

        val requestItem = RegisterItemRequest(tituloItem,categoria,descricaoItem, "im",
        detalhesUso,dataInicioFormatada,dataFimFormatada,valorMultaDouble,valorDiaDouble,false,idUsuarioss,
            CheckEntregaBoolean,CheckPessoalBoolean);

        val apiItens = Apis.getApiItens();

        // instância do EndPoint (chamada) que busca p/ email e senha na API
        val postItem = apiItens.postItens(requestItem);


        postItem.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("Request " + requestItem.toString())
                println("FUNCIONOOOOOU -------------, " + response.body())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("Request " + requestItem.toString())
                println("DEU RUIIM -------------, " + t.message)
            }

        })

    }
}