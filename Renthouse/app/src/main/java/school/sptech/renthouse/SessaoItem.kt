package school.sptech.renthouse

object SessaoItem {
    lateinit var titulo: String
    lateinit var foto : String
    lateinit var descricao : String
    lateinit var detalhesUso : String
    lateinit var idItem: String

    fun initIdItem(idItem:String){
        this.idItem = idItem
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