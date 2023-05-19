package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import retrofit2.Callback
import retrofit2.Response

class HomeActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Esconde a barra de ação
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        val nomeUsuario = SessaoUsuario.usuario.nomeCompleto //
        val idUser = SessaoUsuario.usuario.id

        val nomeUsuarioTextView = findViewById<TextView>(R.id.nameUser_home)
        nomeUsuarioTextView.text = "Olá $nomeUsuario"

        val apiItens = Apis.getApiItens();
        val getItensCatalgo = apiItens.getItensCatalogo(idUser)

        getItensCatalgo.enqueue(object : Callback<List<CatalogoItem>> {
            override fun onResponse(
                call: Call<List<CatalogoItem>>,
                response: Response<List<CatalogoItem>>
            ) {
                if (response.isSuccessful) {
                    val itens = response.body()

                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                    if (itens != null) {
                        for (item in itens) {
                            val myFragment = PosterFragment()
                            val argumentos = Bundle()
                            argumentos.putSerializable("item", item)
                            myFragment.arguments = argumentos
                            fragmentTransaction.add(R.id.fragment_container_home, myFragment)
                        }
                    }

                    fragmentTransaction.commit()
                }
            }
            override fun onFailure(call: Call<List<CatalogoItem>>, t: Throwable) {
                // Tratar falha na chamada ao endpoint
            }
        })

//        getItensCatalgo.enqueue(object : Callback<List<CatalogoItem>> {
//            override fun onResponse(call: Call<List<CatalogoItem>>, response: Response<List<CatalogoItem>>) {
//                if (response.isSuccessful && response.body()!=null && response.body()?.isNotEmpty()!!) {
//
//                    println("deu boom -------------, "+ response.body())
//                    response.body()!!.forEach {
//
//                        // este código abaixo deve estar na fragment
//                        Picasso.with(baseContext)
//                            .load(it?.imagemUrl)
//                            .into(findViewById<ImageView>(R.id.imagem_poster))
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<CatalogoItem>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })

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