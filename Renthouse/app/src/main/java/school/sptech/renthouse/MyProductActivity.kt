package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_product)


        val idUser = SessaoUsuario.usuario.id

        val apiItens = Apis.getApiItens();
        val getItensUser = apiItens.myItensUser(idUser)

        getItensUser.enqueue(object : Callback<List<ItemUserProduct>> {
            override fun onResponse(call: Call<List<ItemUserProduct>>, response: Response<List<ItemUserProduct>>) {
                if (response.isSuccessful && response.body()!=null && response.body()?.isNotEmpty()!!) {

                    println("enzooola -------------, "+ response.body())
                    response.body()!!.forEach {

                        // este código abaixo deve estar na fragment
                        Picasso.with(baseContext)
                            .load(it?.imagemUrl)
                            .into(findViewById<ImageView>(R.id.imagem_poster))
                    }
                }
            }

            override fun onFailure(call: Call<List<ItemUserProduct>>, t: Throwable) {
                    println("Esse erro, "+  t.message)
            }

        })
    }
}