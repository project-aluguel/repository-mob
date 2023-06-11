package school.sptech.renthouse

import com.google.gson.annotations.SerializedName

data class ItemRequestedUser(
    @SerializedName("idNegociacao")
    val idNegociacao: String,

    @SerializedName("nomeItem")
    val nomeItem: String,

    @SerializedName("valorEmprestimo")
    val valorEmprestimo: Double,

    @SerializedName("imagemUrl")
    val imagemUrl: String,

    @SerializedName("idItem")
    val idItem: String,

    @SerializedName("idProprietario")
    val idProprietario: String,

    @SerializedName("nome")
    val nome: String? = null,

    @SerializedName("valorItem")
    val valorItem: Double? = null,

    @SerializedName("dataInicio")
    val dataInicio: String? = null,

    @SerializedName("dataFim")
    val dataFim: String? = null,

) : java.io.Serializable