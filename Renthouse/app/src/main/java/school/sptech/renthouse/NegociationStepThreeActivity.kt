package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NegociationStepThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_negociation_step_three)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }
    fun goToPerfil(view: View?) {
        val intent = Intent(this, NegociationStepTwoActivity::class.java)
        startActivity(intent)
    }

    fun goToNext(view: View?) {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
    }
}