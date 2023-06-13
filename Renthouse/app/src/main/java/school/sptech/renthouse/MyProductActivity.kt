package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProductActivity : AppCompatActivity() {

    fun goToMenuPopup(view: View?) {
        val intent = Intent(this, ModalHomeActivity::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_product)
// Esconde a barra de ação
        supportActionBar?.hide()

        val idUser = SessaoUsuario.usuario.id

        val apiItens = Apis.getApiItens();
        val getItensUser = apiItens.myItensUser(idUser)

        getItensUser.enqueue(object : Callback<List<ItemUserProduct>> {
            override fun onResponse(call: Call<List<ItemUserProduct>>, response: Response<List<ItemUserProduct>>) {
                if (response.isSuccessful && response.body()!=null && response.body()?.isNotEmpty()!!) {

                    val myProducts = response.body()

                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                    if (myProducts != null) {
                        for (item in myProducts) {
                            val myFragment = LockPosterFragment()
                            val argumentos = Bundle()
                            argumentos.putSerializable("myProducts", item)
                            myFragment.arguments = argumentos
                            fragmentTransaction.add(R.id.fragment_container_lock_poster, myFragment)
                        }
                    }

                    fragmentTransaction.commit()

                }
            }

            override fun onFailure(call: Call<List<ItemUserProduct>>, t: Throwable) {
                    println("Esse erro, "+  t.message)
            }

        })
    }
}