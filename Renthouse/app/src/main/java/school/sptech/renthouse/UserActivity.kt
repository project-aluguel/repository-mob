package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        // Esconde a barra de ação
        supportActionBar?.hide()


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
}