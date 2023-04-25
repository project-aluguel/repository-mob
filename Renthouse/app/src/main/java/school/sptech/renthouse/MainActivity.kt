package school.sptech.renthouse

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esconde a barra de ação
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)


    }

    fun goToSignupActivity(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }



    fun entrar(componente: View) {

        // recuperando os componentes de EditText

        val etLogin = findViewById<EditText>(R.id.et_email)
        val etSenha = findViewById<EditText>(R.id.et_senha)

        val homeActivity = Intent(applicationContext, HomeActivity::class.java)

        homeActivity.putExtra("email",etLogin.text.toString())
        homeActivity.putExtra("senha",etSenha.text.toString())

        verificarAutenticacao(componente.context, homeActivity)

    }

    fun verificarAutenticacao(context: Context, homeActivity: Intent) {
        /*
        Aqui estamos solicitando os dados enviados pela Activity anterior
         */
        val emailRecebido = homeActivity.getStringExtra("email")
        val senhaRecebida = homeActivity.getStringExtra("senha")

        // recuperando a TextView da tela

        val tvAutenticacao = findViewById<TextView>(R.id.text_error)

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
                        val idUsuario = response.body()?.id.toString()
                        homeActivity.putExtra("idUsuario", idUsuario)
                        println("----------------------- id " + idUsuario)
                        context.startActivity(homeActivity)
                    } else {
                        println("--------------------------------------------------- Deu ruuim")
                        tvAutenticacao.text = "Login e/ou senha inválidos"
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