package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.*

interface ApiUsuarios {

    @POST("/usuarios/login")
    fun login(@Body body: LoginRequest): Call<Usuario>

    @POST("/usuarios")
    fun criarUsuario(@Body body: UsuarioRequest): Call<String>

    @POST("/carteiras/{idUsuario}")
    fun criarCarteira(@Path("idUsuario") idUsuario: String): Call<String>

    @POST("/enderecos")
    fun salvarEndereco(@Body body: EnderecoRequest): Call<Endereco>

}