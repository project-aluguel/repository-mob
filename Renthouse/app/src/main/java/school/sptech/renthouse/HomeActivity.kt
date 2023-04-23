package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val myFragment = PosterFragment()
        fragmentTransaction.add(R.id.fragment_container_home, myFragment)
        fragmentTransaction.commit()


    }

    fun getAllItens() {
        Apis.getApiUsuarios()
        val apiItens = Apis.getApiItens()
        var listItens:List<Item> = listOf()
    }

    override fun onResume() {
        super.onResume()


    }



}