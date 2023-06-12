package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val usuario = SessaoUsuario.usuario

        getInfosUser(usuario)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            saveChanges(usuario.id)
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun saveChanges(
        idUsuario: String,
//        response: Response<String>
    ) {

        val nomeCompleto = findViewById<EditText>(R.id.nameEditText).text.toString()
        val email = findViewById<EditText>(R.id.emailEditText).text.toString()
        val senha = findViewById<EditText>(R.id.passwordEditText).text.toString()

        val atualizaUsuarioRequest = AtualizaUsuarioRequest(nomeCompleto, email, senha)
        val atualizaUserPut =
            Apis.getApiUsuarios().atualizarUsuario(idUsuario, atualizaUsuarioRequest)

//        GlobalScope.launch(Dispatchers.Main) {
//            try {
//                if (response.isSuccessful) {
//                    showToast("Dados atualizados com sucesso!")
//                    val idUser = response.body().toString()
//                    SessaoUsuario.initIdUser(idUser)
//                } else {
//                    showToast("Erro ao atualizar dados do usuário")
//                }
//            } catch (e: Exception) {
//                showToast("Erro na conexão com a API")
//            }
//        }

        atualizaUserPut.enqueue(
            object : Callback<AtualizaUsuario> {
                override fun onResponse(
                    call: Call<AtualizaUsuario>,
                    response: Response<AtualizaUsuario>
                ) {
                    if (response.isSuccessful) {
                        val activityWallet = Intent(applicationContext, activity_wallet::class.java)
                        val idUser = response.body().toString()
                        println("-------------------------------------------- EU SOU ID, " + idUser)
                        SessaoUsuario.initIdUser(response.body().toString()!!)
                        applicationContext.startActivity(activityWallet)
                    } else {
                        // Trate o caso em que a resposta não é bem-sucedida
                    }
                }

                override fun onFailure(call: Call<AtualizaUsuario>, t: Throwable) {
                    println(" -----------------------------------------" + t.message)
                    t.printStackTrace()
                }
            }
        )

        // Exemplo de exibição dos dados atualizados
        val message = "Nome: $nomeCompleto\nEmail: $email"
        showToast(message)
    }


    fun getInfosUser(usuario: Usuario) {
        findViewById<EditText>(R.id.nameEditText).setText(usuario.nomeCompleto)
        findViewById<EditText>(R.id.emailEditText).setText(usuario.email)
//        findViewById<EditText>(R.id.addressEditText).setText(usuario.end)

        Apis.getApiUsuarios().getUsuario(SessaoUsuario.usuario.id).enqueue(
            object : Callback<Usuario> {
                override fun onResponse(
                    call: Call<Usuario>,
                    response: Response<Usuario>
                ) {
                    if (response.isSuccessful) {

                        // Nome completo
                        val name = response.body()?.nomeCompleto ?: "seu nome"
                        val editableName = Editable.Factory.getInstance().newEditable(name)
                        findViewById<EditText>(R.id.nameEditText)?.text = editableName


                        // Email
                        val email = response.body()?.email ?: "seu email"
                        val editableEmail = Editable.Factory.getInstance().newEditable(email)
                        findViewById<EditText>(R.id.emailEditText)?.text = editableEmail

                        // senha
                        val senha = response.body()?.senha ?: "sua senha"
                        val editableSenha = Editable.Factory.getInstance().newEditable(senha)
                        findViewById<EditText>(R.id.passwordEditText)?.text = editableSenha

                    } else {
                        // Trate o caso em que a resposta não é bem-sucedida
                    }
                }

                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    println(" -----------------------------------------" + t.message)
                    t.printStackTrace()
                }
            }
        )
    }
}