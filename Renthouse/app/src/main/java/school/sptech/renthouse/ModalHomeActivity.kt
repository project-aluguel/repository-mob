package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ModalHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esconde a barra de ação
        supportActionBar?.hide()
        setContentView(R.layout.activity_modal_home)
    }
    fun goToPerfil(view: View?) {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
    }
    fun goToCarteira(view: View?) {
        val intent = Intent(this, activity_wallet::class.java)
        startActivity(intent)
    }
    fun goToHome(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
