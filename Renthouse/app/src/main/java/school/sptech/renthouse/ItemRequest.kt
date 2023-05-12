package school.sptech.renthouse

import java.time.LocalDate
import java.time.LocalDateTime

data class ItemRequest(val id: String , val nome:String, val valorItem: Double,
val imagemUrl: String, val dataInicio: String,val dataFim: String) {
}