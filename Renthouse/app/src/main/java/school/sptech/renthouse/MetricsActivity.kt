package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetricsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrics)

        val idUser = SessaoUsuario.usuario.id

        val apiItens = Apis.getApiItens();
        val getMetricsItem = apiItens.getMetricsItem(idUser)

        getMetricsItem.enqueue( object : Callback<ItemRent> {
            override fun onResponse(
                call: Call<ItemRent>,
                response: Response<ItemRent>
            ) {
                if (response.isSuccessful && response.body()!=null) {

                    val myItems = response.body()

                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

//                    if (myItems != null) {
//                        for (item in myItems) {
//                            val myFragment = MyRequestItem()
//                            val argumentos = Bundle()
//                            argumentos.putSerializable("myItem", item)
//                            myFragment.arguments = argumentos
//                            fragmentTransaction.add(R.id.fragment_container_my_request, myFragment)
//                        }
//                    }

                    fragmentTransaction.commit()
                }
            }

            override fun onFailure(call: Call<ItemRent>, t: Throwable) {
                println("---------- foge que deu ruim, " + t.message)
            }

        })

    }
}