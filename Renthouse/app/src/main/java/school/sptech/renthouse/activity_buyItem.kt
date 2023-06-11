package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_buyItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_item)
        // Esconde a barra de ação
        supportActionBar?.hide()

        val idItem = SessaoItem.idItem

        println("achou, "+ idItem)

        val apiItens = Apis.getApiItens();
        val getItemRent = apiItens.getItemRent(idItem)

        getItemRent.enqueue(object : Callback<ItemRent>{
            override fun onResponse(call: Call<ItemRent>, response: Response<ItemRent>) {
                if (response.isSuccessful) {
                    val itemBuy = response.body()

                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()

                            val myFragment = ItemRented()
                            val argumentos = Bundle()
                            argumentos.putSerializable("itemRent", itemBuy)
                            myFragment.arguments = argumentos

                    //Verifcar a existencia desse id na develop ou branch do tipo
//                            fragmentTransaction.add(R.id.fragment_item_rented, myFragment)

                    fragmentTransaction.commit()
                }
            }

            override fun onFailure(call: Call<ItemRent>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })



    }

    fun goToHome(view: View?) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }



}