package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class activity_wallet2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet2)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }
    fun goToPerfil(view: View?) {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
    }
}