package school.sptech.renthouse

object SessaoUsuario {
    lateinit var usuario: Usuario
    lateinit var idUserFixed : String
    lateinit var idCarteira : String

    fun initUsuario(usuario: Usuario){
        this.usuario = usuario;
    }

    fun initIdUser(idUserFixed: String){
        this.idUserFixed = idUserFixed;
    }

    fun initIdCarteira(idCarteira : String){
        this.idCarteira = idCarteira
    }

}