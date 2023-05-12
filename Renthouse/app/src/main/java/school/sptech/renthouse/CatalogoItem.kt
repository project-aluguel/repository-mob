package school.sptech.renthouse

data class CatalogoItem(val id: String , val nome:String, val valorItem: Double,
                   val imagemUrl: String, val dataInicio: String,val dataFim: String): java.io.Serializable {
}