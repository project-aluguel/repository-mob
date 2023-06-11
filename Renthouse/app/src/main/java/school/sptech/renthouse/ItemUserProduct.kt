package school.sptech.renthouse

import java.time.LocalDate
import java.time.LocalDateTime

data class ItemUserProduct(val idItem:String, val nome:String,val manualUso:String,val dataInicio: String,
                           val dataFim: String, val descricao:String, val imagemUrl:String, val categoria:String,
                           val valorItem: Double, val valorGarantia:Double,
                           val status:String, val entregaFrete:Boolean, val entregaPessoal:Boolean):java.io.Serializable {

}