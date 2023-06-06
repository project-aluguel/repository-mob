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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ItemRented.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemRented : Fragment() {
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
        return inflater.inflate(R.layout.fragment_item_rented, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = arguments?.getSerializable("itemRent") as ItemRent
        val nomeProduto = view.findViewById<TextView>(R.id.nome_item)
        val valorProduto = view.findViewById<TextView>(R.id.valor_item)
        val imgView = view.findViewById<ImageView>(R.id.img_produto)
        val descricao = view.findViewById<TextView>(R.id.item_descricao)
        val imgUrl = item.imagemUrl
        println("imagem vem assim, " + imgUrl)
        Glide.with(this).load(imgUrl).into(imgView);
        nomeProduto?.text = item.nome
        valorProduto?.text = "R$${item.valorItem} Dia"
        descricao?.text = item.descricao

    }
}