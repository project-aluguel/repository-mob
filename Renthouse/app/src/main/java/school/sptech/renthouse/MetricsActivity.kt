package school.sptech.renthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetricsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrics)
        val extras = intent.extras

        val myRequestItens = extras?.getString("idItemRent")

        val apiItens = Apis.getApiItens()
        val getMetricsItem = apiItens.getMetricsItem(myRequestItens ?: "")

        getMetricsItem.enqueue( object : Callback<ItemRent> {
            override fun onResponse(
                call: Call<ItemRent>,
                response: Response<ItemRent>
            ) {
                if (response.isSuccessful && response.body()!=null) {

                    val item = response.body()

                    if (item != null) {
                        val imagePosterMetric = findViewById<ImageView>(R.id.imagePosterMetric)
                        Glide.with(applicationContext).load(item.imagemUrl).into(imagePosterMetric)

                        findViewById<TextView>(R.id.nameItemMetric).text = item.nome
                    }


                }
            }

            override fun onFailure(call: Call<ItemRent>, t: Throwable) {
                println("---------- foge que deu ruim, " + t.message)
            }

        })

    }
}