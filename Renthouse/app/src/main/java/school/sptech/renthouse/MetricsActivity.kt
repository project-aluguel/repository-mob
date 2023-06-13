package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetricsActivity : AppCompatActivity() {
    fun goToHome(view: View?) {
        val intent = Intent(this, MyProductActivity::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        // Esconde a barra de ação
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metrics)
        val idItem = SessaoItemMetrica.idItemMetrica
        val imgUrl = SessaoItemMetrica.fotoMetrica;
        val titulo = SessaoItemMetrica.tituloMetrica;


        val apiItens = Apis.getApiItens()
        val getMetricsItem = apiItens.getMetricsItem(idItem)

        getMetricsItem.enqueue( object : Callback<ItemRent> {
            override fun onResponse(
                call: Call<ItemRent>,
                response: Response<ItemRent>
            ) {

                    val item = response.body()
                    println("Esse é o ITEM ------------------------------------------------ , " + item?.mediaDiasAlugadosPorNegociacao.toString())

                    if (item != null) {
                        val imagePosterMetric = findViewById<ImageView>(R.id.imagePosterMetric)
                        Glide.with(applicationContext).load(imgUrl).into(imagePosterMetric)
                        findViewById<TextView>(R.id.nameItemMetric).text = titulo

                        findViewById<TextView>(R.id.nameMetricDias).text = item.mediaDiasAlugadosPorNegociacao
                        findViewById<TextView>(R.id.nameMetricVizu).text = item.qtdVisualizacao
                        findViewById<TextView>(R.id.nameMetricQuant).text = item.qtdNegociacao
                        findViewById<TextView>(R.id.nameMetricApro).text = item.mediaFeedback
                    }

            }
            override fun onFailure(call: Call<ItemRent>, t: Throwable) {
                println("---------- foge que deu ruim, " + t.message)
            }
        })
    }
}