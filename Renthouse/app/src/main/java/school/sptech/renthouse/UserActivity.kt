package school.sptech.renthouse

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class UserActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        // Esconde a barra de ação
        supportActionBar?.hide()

        val nomeUsuario = SessaoUsuario.usuario.nomeCompleto //
        val nomeUsuarioTextView = findViewById<TextView>(R.id.nameUser_profile)
        nomeUsuarioTextView.text = "Olá $nomeUsuario você possui"
    }

    fun goToCarteira(view: View?) {
        val intent = Intent(this, activity_wallet::class.java)
        startActivity(intent)
    }
    fun goToCadastrarProduto(view: View?) {
        val intent = Intent(this, NegociationStepOneActivity::class.java)
        startActivity(intent)
    }
    fun goToHome(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    fun goToCadastrarItem(view: View?) {
        val intent = Intent(this, RegisterProductActivity::class.java)
        startActivity(intent)
    }


}