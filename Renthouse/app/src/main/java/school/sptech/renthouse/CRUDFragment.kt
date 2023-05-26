package school.sptech.renthouse

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CRUDFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_r_u_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usuario = SessaoUsuario.usuario
        view.findViewById<EditText>(R.id.nameEditText).setText(usuario.nomeCompleto)
        view.findViewById<EditText>(R.id.emailEditText)
        view.findViewById<EditText>(R.id.addressEditText)
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun saveChanges(idUsuario:String, context: Context,CRUDFragment : Intent, response: Response<String>) {
        val view = view ?: return

        val nameEditText = view.findViewById<EditText>(R.id.nameEditText)
        val emailEditText = view.findViewById<EditText>(R.id.emailEditText)
        val addressEditText = view.findViewById<EditText>(R.id.addressEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)

        val nomeCompleto = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val endereco = addressEditText.text.toString()
        val senha = passwordEditText.text.toString()

        val apiUser = Apis.getApiUsuarios()
        val atualizaUsuarioRequest = AtualizaUsuarioRequest(nomeCompleto, email, endereco , senha)
        val atualizaUserPut = apiUser.atualizarUsuario(idUsuario,atualizaUsuarioRequest)

        GlobalScope.launch(Dispatchers.Main) {
            try {
                if (response.isSuccessful) {
                    showToast("Dados atualizados com sucesso!")
                    val idUser = response.body().toString()
                    SessaoUsuario.initIdUser(idUser)
                } else {
                    showToast("Erro ao atualizar dados do usuário")
                }
            } catch (e: Exception) {
                showToast("Erro na conexão com a API")
            }
        }

        atualizaUserPut.enqueue(
            object : Callback<AtualizaUsuario> {
                override fun onResponse(call: Call<AtualizaUsuario>, response: Response<AtualizaUsuario>) {
                    if (response.isSuccessful) {
                        val activityWallet = Intent(context, activity_wallet::class.java)
                        val idUser = response.body().toString()
                        println("-------------------------------------------- EU SOU ID, " + idUser)
                        SessaoUsuario.initIdUser(response.body().toString()!!)
                        context.startActivity(activityWallet)
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
        val message = "Nome: $nomeCompleto\nEmail: $email\nEndereço: $endereco"
        showToast(message)
    }

    }
