package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.view.View

class HomeActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esconde a barra de ação
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

    }
//    fun getAllItens() {
//        val intent = intent
//        val id = intent.getStringExtra("id")
//
//        val apiItens = Apis.getApiItens()
//        val chamadaPOST = apiItens.getItens(id!!);
//        val itens: List<Call<ItemRequest>> = listOf(chamadaPOST);
//
//
//        for (item in itens) {
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            val myFragment = PosterFragment()
//            fragmentTransaction.add(R.id.fragment_container_home, myFragment)
//            fragmentTransaction.commit()
//        }
//    }
fun goToMenuPopup(view: View?) {
    val intent = Intent(this, ModalHomeActivity::class.java)
    startActivity(intent)
}
}