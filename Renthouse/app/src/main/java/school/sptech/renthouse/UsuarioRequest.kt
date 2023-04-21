package school.sptech.renthouse

import java.time.LocalDate

class UsuarioRequest(val email: String, val senha: String, val nomeCompleto: String, val dataNascimento
: LocalDate, val cpf: String,  val telefone: String){}