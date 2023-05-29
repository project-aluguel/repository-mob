package school.sptech.renthouse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PosterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PosterFragment : Fragment() {
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



        return inflater.inflate(R.layout.fragment_poster, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = arguments?.getSerializable("item") as CatalogoItem
        val nomeProduto = view.findViewById<TextView>(R.id.nome)
        val valorProduto = view.findViewById<TextView>(R.id.valor)
        val imgView = view.findViewById<ImageView>(R.id.imagem_poster)
        val imgUrl = item.imagemUrl
        Picasso.with(context).load(imgUrl).into(imgView)
        nomeProduto?.text = item.nome
        valorProduto?.text = "R$${item.valorItem} Dia"
    }
}
