package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivityCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cadastro)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }

    fun goToSigninActivity(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
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
}