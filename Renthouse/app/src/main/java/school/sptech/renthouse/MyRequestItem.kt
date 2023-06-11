package school.sptech.renthouse

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MyRequestItem : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.my_request_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myRequestItens = arguments?.getSerializable("myItem") as ItemRequestedUser
        val nomeProduto = view.findViewById<TextView>(R.id.nome)
        val valorProduto = view.findViewById<TextView>(R.id.valor)
        val imgView = view.findViewById<ImageView>(R.id.imagem_poster)
        val imgUrl = myRequestItens.imagemUrl
        //Picasso.with(context).load(imgUrl).into(imgView)
        Glide.with(this).load(imgUrl).into(imgView)
        nomeProduto?.text = myRequestItens.nomeItem
        valorProduto?.text = "R$${myRequestItens.valorEmprestimo} Dia"

        view.setOnClickListener {
            // Criar um Intent para iniciar a nova atividade
            val intent = Intent(activity, MetricsActivity::class.java)
            val argumentos = Bundle()
            argumentos.putString("idItemRent", myRequestItens.idItem)
            // Passar o ID do item como um extra para a nova atividade
            println("esse id ------------------------, "+ myRequestItens.idItem)
            SessaoItem.initIdItem(myRequestItens.idItem)
            // Iniciar a nova atividade
            startActivity(intent, argumentos)
        }
    }
}