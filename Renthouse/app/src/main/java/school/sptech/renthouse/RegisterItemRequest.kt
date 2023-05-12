package school.sptech.renthouse

class RegisterItemRequest(
    val nome: String,
    val categoria: String,
    val descricao: String,
    val imagemUrl: String,
    val manualUso: String,
    val dataInicio: String,
    val dataFim: String,
    val valorGarantia: Double,
    val valorItem: Double,
    val alugado: Boolean,
    val idUsuario: String,
    val entregaFrete: Boolean,
    val entregaPessoal: Boolean
)
