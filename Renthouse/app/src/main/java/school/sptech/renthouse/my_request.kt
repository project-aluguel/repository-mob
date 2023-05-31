package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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

                    val myItems = response.body()

                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                    if (myItems != null) {
                        for (item in myItems) {
                            val myFragment = MyRequestItem()
                            val argumentos = Bundle()
                            argumentos.putSerializable("myItem", item)
                            myFragment.arguments = argumentos
                            fragmentTransaction.add(R.id.fragment_container_my_request, myFragment)
                        }
                    }

                    fragmentTransaction.commit()
                }
            }

            override fun onFailure(call: Call<List<ItemRequestedUser>>, t: Throwable) {
                    println("---------- foge que deu ruim, " + t.message)
            }

        })

    }


}