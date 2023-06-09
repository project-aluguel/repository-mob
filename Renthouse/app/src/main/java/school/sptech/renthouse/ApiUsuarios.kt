package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.*

interface ApiUsuarios {

    @POST("/usuarios/login")
    fun login(@Body body: LoginRequest): Call<Usuario>

    @GET("/usuarios/{idUsuario}")
    fun getUsuario(
        @Path("idUsuario") idUsuario: String
    ): Call<Usuario>

    @POST("/usuarios")
    fun criarUsuario(@Body body: UsuarioRequest): Call<String>

    @PUT("{idUsuario}")
    fun atualizarUsuario(
        @Path("idUsuario") idUsuario: String,
        @Body body: AtualizaUsuarioRequest
    ): Call<AtualizaUsuario>

    @POST("/carteiras/{idUsuario}")
    fun criarCarteira(@Path("idUsuario") idUsuario: String): Call<String>

    @POST("/enderecos")
    fun salvarEndereco(@Body body: EnderecoRequest): Call<Endereco>

}