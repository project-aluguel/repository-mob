package school.sptech.renthouse

data class ItemRequestedUser(val idNegociacao: String,
                             val nomeItem: String,
                             val valorEmprestimo: Double,
                             val imagemUrl: String,
                             val idItem: String,
                             val idProprietario: String){
}