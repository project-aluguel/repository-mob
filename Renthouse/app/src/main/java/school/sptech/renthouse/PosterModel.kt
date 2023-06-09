package school.sptech.renthouse

data class PosterModel(
    val id: String,
    val nome: String,
    val valorItem: Double,
    val imagemUrl: String,
    val dataInicio: String,
    val dataFim: String,
)