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
//import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyRequestItem.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyRequestItem : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
        Glide.with(this).load(imgUrl).into(imgView);
        nomeProduto?.text = myRequestItens.nomeItem
        valorProduto?.text = "R$${myRequestItens.valorEmprestimo} Dia"

        view.setOnClickListener {
            // Criar um Intent para iniciar a nova atividade
            val intent = Intent(activity, activity_buyItem::class.java)

            // Passar o ID do item como um extra para a nova atividade
            println("esse id ------------------------, "+ myRequestItens.idItem)
            SessaoItem.initIdItem(myRequestItens.idItem)
            // Iniciar a nova atividade
            startActivity(intent)
        }
    }
}