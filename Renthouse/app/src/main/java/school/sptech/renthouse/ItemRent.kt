package school.sptech.renthouse

import java.time.LocalDate
import java.time.LocalDateTime

data class ItemRent(val id:String,
                    val nome:String,
                    val categoria:String,
                    val descricao:String,
                    val imagemUrl:String,
                    val manualUso:String,
                    val dataInicio: String,
                    val dataFim: String,
                    val valorGarantia:Double,
                    val valorItem:Double,
                    val alugado:Boolean,
                    val idProprietario: String,
                    val entregaFrete:Boolean,
                    val entregaPessoal:Boolean):java.io.Serializable {
}