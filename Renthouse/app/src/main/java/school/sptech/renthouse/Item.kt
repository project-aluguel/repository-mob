package school.sptech.renthouse

import java.time.LocalDate
import java.time.LocalDateTime

data class Item(
    val id:String, val nome:String, val categoria:String,
    val descricao:String, val imagemUrl:String, val manualUso:String,
    val dataInicio:LocalDate, val dataFim:LocalDate, val criadoEm:LocalDateTime,
    val atualizadoEm:LocalDateTime, val valorGarantia:Double, val valorItem:Double,
    val alugado:Boolean, val entregaFrete:Boolean, val entregaPessoal:Boolean,
    val usuarioModel:Usuario
)
