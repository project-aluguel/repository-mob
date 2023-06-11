package school.sptech.renthouse

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LockPosterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LockPosterFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_lock_poster, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myProductsItem = arguments?.getSerializable("myProducts") as ItemUserProduct
        val statusLock = myProductsItem.status
        println("---------------, " + statusLock)
        val nomeProduto = view.findViewById<TextView>(R.id.nome)
        val valorProduto = view.findViewById<TextView>(R.id.valor)
        val imgView = view.findViewById<ImageView>(R.id.imagem_poster)
        val imgUrl = myProductsItem.imagemUrl
        // Picasso.with(context).load(imgUrl).into(imgView)
        Glide.with(this).load(imgUrl).into(imgView);


        val imgLock = view.findViewById<ImageView>(R.id.lock)

        val opcao = 2

        when (statusLock) {
            "disponivel" -> {
                println("Opção 1 selecionada")
                val greenLock = ContextCompat.getDrawable(requireContext(), R.drawable.green_lock)
                Glide.with(this).load(greenLock).into(imgLock);

            }
            "ativo" -> {
                println("Opção 2 selecionada")
            }
            else -> {
                println("Opção inválida")
                // Faça algo aqui para opções inválidas
            }
        }

        nomeProduto?.text = myProductsItem.nome
        valorProduto?.text = "R$${myProductsItem.valorItem} Dia"

        view.setOnClickListener {
            // Criar um Intent para iniciar a nova atividade
            val intent = Intent(activity, activity_buyItem::class.java)

            // Passar o ID do item como um extra para a nova atividade
            println("esse id ------------------------, "+ myProductsItem.idItem)
            SessaoItem.initIdItem(myProductsItem.idItem)
            // Iniciar a nova atividade
            startActivity(intent)
        }
    }

}