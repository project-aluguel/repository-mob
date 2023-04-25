package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_buyItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_item)
        // Esconde a barra de ação
        supportActionBar?.hide()
    }

    fun goToHome(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }



}