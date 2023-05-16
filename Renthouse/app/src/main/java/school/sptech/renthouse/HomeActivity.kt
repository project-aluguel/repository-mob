package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import retrofit2.Call
import android.view.View
import android.view.ViewGroup

class HomeActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esconde a barra de ação
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)


        val i1:ItemRequest? = null
        val i2:ItemRequest? = null
        val i3:ItemRequest? = null
        val i4:ItemRequest? = null
        val itens = listOf(i1, i2, i3, i4);

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        for (item in itens) {
            val myFragment = PosterFragment()
            val argumentos = Bundle()
            argumentos.putSerializable("item", item)
            myFragment.arguments = argumentos
            fragmentTransaction.add(R.id.fragment_container_home, myFragment)
        }

        fragmentTransaction.commit()
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
    fun goToMock(view: View?) {
    val intent = Intent(this, activity_buyItem::class.java)
    startActivity(intent)
}
}