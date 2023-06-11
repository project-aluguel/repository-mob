package school.sptech.renthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class RegisterProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_product)
    }


   fun goToStepRegister2(view: View?){
       val etTitulo = findViewById<EditText>(R.id.titulo_item)
       val etDescricao = findViewById<EditText>(R.id.descricao)
       val etDetalhes = findViewById<EditText>(R.id.manual_uso)
       val etImagem = findViewById<EditText>(R.id.url_image)


       val intent = Intent(this, RegisterProductStepTwoActivity::class.java)
       startActivity(intent)



   }


}