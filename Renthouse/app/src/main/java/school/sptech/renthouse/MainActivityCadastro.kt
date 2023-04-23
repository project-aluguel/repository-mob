package school.sptech.renthouse

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivityCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cadastro)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }

    @RequiresApi(Build.VERSION_CODES.O)
   public fun goToSigninActivity(componente: View) {
        val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun goToSigninActivityCadastro(componente: View) {
        val mainActivity = Intent(this, MainActivity::class.java)
        cadastrar(componente.context, mainActivity)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun cadastrar(context: Context, mainActivity: Intent){

        val etNomeCompleto = findViewById<EditText>(R.id.cdt_name);
        val etEmailCdt = findViewById<EditText>(R.id.cdt_email)
        val etSenhaCdt = findViewById<EditText>(R.id.cdt_senha)
        val etConfirmaSenha = findViewById<EditText>(R.id.cdt_confirma_senha)
        val etTelefone = findViewById<EditText>(R.id.cdt_telefone)
        val etCpf = findViewById<EditText>(R.id.cdt_cpf)
        val etCep = findViewById<EditText>(R.id.cdt_cep)

        val etDataNascimento = findViewById<EditText>(R.id.cdt_nascimento)
        val dataNascimentoString = etDataNascimento.text.toString()
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        val dataNascimento = LocalDate.parse(dataNascimentoString, formatter)
        // agora você pode usar a data formatada como quiser
        val dataNascimentoFormatada = dataNascimento.format(formatter)


        val nomeCompleto = etNomeCompleto.text.toString()
        val email_cadastro = etEmailCdt.text.toString()
        val senha_cadastro = etSenhaCdt.text.toString()
        val confirma_senha = etConfirmaSenha.text.toString()
        val cpf = etCpf.text.toString()
        val cep = etCep.text.toString()
        val telefone = etTelefone.text.toString()




        val requestUser = UsuarioRequest(email_cadastro!!,senha_cadastro!!,
            nomeCompleto!!,dataNascimentoFormatada!!,cpf!!,telefone!!)

        val apiUser = Apis.getApiUsuarios();
        val apiViaCep = Apis.getApiViaCep()

        val criarUserPost = apiUser.criarUsuario(requestUser)
if(senha_cadastro == confirma_senha)
{
    criarUserPost.enqueue(
        object : Callback<String> {

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val idUser = response.body()
                    context.startActivity(mainActivity)
                } else {
                    println("--------------------------------------------------- Deu ruuim")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println(" -----------------------------------------" + t.message)
                t.printStackTrace()
            }
        },
    )
}
        else{
            println("deu ruim")
        }




    }
}