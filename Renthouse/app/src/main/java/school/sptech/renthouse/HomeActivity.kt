package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import retrofit2.Call
import android.view.View
import android.view.ViewGroup
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        val api = Apis.getApiItens()
        val call = api.getAllItens()

        call.enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
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

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                // Tratar falha na chamada ao endpoint
            }
        })
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