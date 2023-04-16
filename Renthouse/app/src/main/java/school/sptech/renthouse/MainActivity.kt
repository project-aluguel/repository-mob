package school.sptech.renthouse

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun entrar(componente: View) {

        // recuperando os componentes de EditText

        val etLogin = findViewById<EditText>(R.id.et_email)
        val etSenha = findViewById<EditText>(R.id.et_senha)

        val activityBuyItem = Intent(applicationContext, activity_buyItem::class.java)

        activityBuyItem.putExtra("email",etLogin.text.toString())
        activityBuyItem.putExtra("senha",etSenha.text.toString())

        verificarAutenticacao(componente.context, activityBuyItem)

    }

    fun verificarAutenticacao(context: Context, activityBuyItem: Intent) {
        /*
        Aqui estamos solicitando os dados enviados pela Activity anterior
         */
        val emailRecebido = activityBuyItem.getStringExtra("email")
        val senhaRecebida = activityBuyItem.getStringExtra("senha")

        // recuperando a TextView da tela

        val request = LoginRequest(emailRecebido!!,senhaRecebida!!);
        // instância do cliente da API
        val apiUsuarios = Apis.getApiUsuarios()

        // instância do EndPoint (chamada) que busca p/ email e senha na API
        val chamadaPOST = apiUsuarios.login(request);

        // importar o Callback do retrofit2
        chamadaPOST.enqueue(
            object : Callback<Usuario> {

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if (response.isSuccessful) { // se o status é 2xx
                        print("------------------------------------------- FUNCIONOU")
                        context.startActivity(activityBuyItem)
                    } else {
                        println("--------------------------------------------------- Deu ruuim")
                    }
                }

                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    println(" -----------------------------------------" + t.message)
                    t.printStackTrace()
                }

            },
            // quando NÃO houver comunicação com a API
        )
    }

}