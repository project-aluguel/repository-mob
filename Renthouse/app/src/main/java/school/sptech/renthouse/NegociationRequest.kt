package school.sptech.renthouse

class NegociationRequest(val dataInicio: String, val dataFim: String, val valorEmprestimo: Double,
                         val valorFrete: Double, val idItem: String,  val idProprietario: String,
                         val idAlugador: String) {
}