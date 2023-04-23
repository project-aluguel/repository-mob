package school.sptech.renthouse

import java.time.LocalDate
import java.time.LocalDateTime

data class Item(val id:String,val categoria:String, val descricao:String,
                val imageUrl:String, val nome:String,
                val alugado:Boolean, val entregaFrete:Boolean, val entregaPessoal:Boolean,
                val valorGarantia:Double, val valorItem:Double,
                val manualUso:String,val dataInicio:LocalDate, val dataFim:LocalDate,
                val criadoEm:LocalDateTime, val atualizadoEm:LocalDateTime,
                val usuarioModel:Usuario) {

}
