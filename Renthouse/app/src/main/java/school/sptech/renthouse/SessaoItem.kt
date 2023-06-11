package school.sptech.renthouse

import kotlin.properties.Delegates

object SessaoItem {
    lateinit var titulo: String
    lateinit var foto : String
    lateinit var descricao : String
    lateinit var detalhesUso : String
    lateinit var idItem: String
    lateinit var idProprietario: String
    var valorItem by Delegates.notNull<Double>();

    fun initIdItem(idItem:String){
        this.idItem = idItem
    }

    fun initIdProprietario(idProprietario: String){
        this.idProprietario = idProprietario
    }
    fun initValorItem(valorItem: Double){
        this.valorItem = valorItem;
    }


    fun initTitulo(titulo: String){
        this.titulo = titulo;
    }

    fun initFoto(foto: String){
        this.foto = foto;
    }

    fun initDescricao(descricao : String){
        this.descricao = descricao
    }

    fun initDetalhesUso(detalhesUso : String){
        this.detalhesUso = detalhesUso
    }
}