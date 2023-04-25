package school.sptech.renthouse

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esconde a barra de ação
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)


    }

    fun goToSignupActivity(view: View?) {
        val intent = Intent(this, MainActivityCadastro::class.java)
        startActivity(intent)
    }

    fun cadastrarUsuario(componente: View){

        val etNomeCompleto = findViewById<EditText>(R.id.cdt_name);
        val etEmailCdt = findViewById<EditText>(R.id.cdt_email)
        val etSenhaCdt = findViewById<EditText>(R.id.cdt_senha)
        val etConfirmaSenha = findViewById<EditText>(R.id.cdt_confirma_senha)
        val etCelular = findViewById<EditText>(R.id.cdt_celular)
        val etDataNascimento = findViewById<EditText>(R.id.cdt_nascimento)
        val etCpf = findViewById<EditText>(R.id.cdt_cpf)
        val etCep = findViewById<EditText>(R.id.cdt_cep)

        val activityBuyItem = Intent(applicationContext, activity_buyItem::class.java)

        activityBuyItem.putExtra("nome",etNomeCompleto.text.toString())
        activityBuyItem.putExtra("email",etEmailCdt.text.toString())
        activityBuyItem.putExtra("senha",etSenhaCdt.text.toString())
        activityBuyItem.putExtra("confirmar_senha",etConfirmaSenha.text.toString())
        activityBuyItem.putExtra("celular",etCelular.text.toString())
        activityBuyItem.putExtra("data_nascimento",etDataNascimento.text.toString())
        activityBuyItem.putExtra("cpf",etCpf.text.toString())
        activityBuyItem.putExtra("cep",etCep.text.toString())


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
                        val userId = response.body()?.id
                        val activityHome = Intent(applicationContext, HomeActivity::class.java)
                        activityHome.putExtra("id", userId.toString())
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