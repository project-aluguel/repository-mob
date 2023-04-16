package school.sptech.renthouse

import com.google.gson.annotations.SerializedName

data class Usuario(   val id:String,val autenticado:Boolean, val email:String,
val senha:String, val nomeCompleto:String,val dataNascimento:String, val cpf:String,
val telefone:String,val criadoEm:String, val atualizadoEm:String ) {

}