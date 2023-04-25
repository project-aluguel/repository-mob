package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiUsuarios {

    @POST("/usuarios/login")
    fun login(@Body body: LoginRequest): Call<Usuario>

    @POST("/usuarios")
    fun criarUsuario(@Body body: UsuarioRequest): Call<String>

    @POST("/enderecos")
    fun salvarEndereco(@Body body: EnderecoRequest): Call<Endereco>

}