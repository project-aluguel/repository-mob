package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esconde a barra de ação
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)
    }
    fun getAllItens() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val myFragment = PosterFragment()
        fragmentTransaction.add(R.id.fragment_container_home, myFragment)
        fragmentTransaction.commit()
    }

    override fun onResume() {
        super.onResume()
        getAllItens()
    }

    fun goToMenuPopup(view: View?) {
        val intent = Intent(this, ModalHomeActivity::class.java)
        startActivity(intent)
    }
}