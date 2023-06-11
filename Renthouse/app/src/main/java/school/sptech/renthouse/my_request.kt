package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class my_request : AppCompatActivity() {

    fun goToMenuPopup(view: View?) {
        val intent = Intent(this, ModalHomeActivity::class.java)
        startActivity(intent)
    }
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

//        val searchEditText = findViewById<EditText>(R.id.editSearchMyProducts)
//
//        searchEditText.setOnEditorActionListener { _, actionId, _ ->
//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//
//                val valor = searchEditText.text.toString()
//
//                true
//            } else {
//                false
//            }
//        }

        val idUser2 = SessaoUsuario.usuario.id


        findViewById<EditText>(R.id.editSearchMyProducts).setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                apiItens.getSearchItemByUser(idUser2, findViewById<EditText>(R.id.editSearchMyProducts).text.toString()).enqueue(
                    object :Callback<List<ItemRequestedUser>>{
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
                            } else {
                                Toast.makeText(applicationContext, "Nenhum resultado encontrado", Toast.LENGTH_SHORT, ).show()
                            }
                        }

                        override fun onFailure(call: Call<List<ItemRequestedUser>>, t: Throwable) {
                            println("---------- foge que deu ruim, " + t.message)
                        }

                    })
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

    }


}