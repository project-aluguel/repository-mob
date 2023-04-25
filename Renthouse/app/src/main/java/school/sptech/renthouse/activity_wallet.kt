package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class activity_wallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }

    fun goToWallet2(view: View?) {
        val intent = Intent(this, activity_wallet2::class.java)
        startActivity(intent)
    }
}