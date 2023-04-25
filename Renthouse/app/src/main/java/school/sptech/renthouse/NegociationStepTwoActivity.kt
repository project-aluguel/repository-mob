package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NegociationStepTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_negociation_step_two)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }
    fun goToPerfil(view: View?) {
        val intent = Intent(this, NegociationStepOneActivity::class.java)
        startActivity(intent)
    }

    fun goToNext(view: View?) {
        val intent = Intent(this, NegociationStepThreeActivity::class.java)
        startActivity(intent)
    }
}