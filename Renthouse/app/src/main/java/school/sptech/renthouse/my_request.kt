package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class my_request : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_request)

        val idUser = SessaoUsuario.usuario.id

        val apiItens = Apis.getApiItens();
        val getItensRequestUser = apiItens.myItensResquestUser(idUser)

        getItensRequestUser.enqueue( object :Callback<List<ItemRequestedUser>>{
            override fun onResponse(
                call: Call<List<ItemRequestedUser>>,
                response: Response<List<ItemRequestedUser>>
            ) {
                if (response.isSuccessful && response.body()!=null && response.body()?.isNotEmpty()!!) {

                    println("DEU BUUUM! -------------, "+ response.body())
                    response.body()!!.forEach {

                        // este código abaixo deve estar na fragment
                        Picasso.with(baseContext)
                            .load(it?.imagemUrl)
                            .into(findViewById<ImageView>(R.id.imagem_poster))
                    }
                }
            }

            override fun onFailure(call: Call<List<ItemRequestedUser>>, t: Throwable) {
                    println("---------- foge que deu ruim, " + t.message)
            }

        })

    }


}