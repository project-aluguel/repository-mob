package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NegociationStepThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_negociation_step_three)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }
}