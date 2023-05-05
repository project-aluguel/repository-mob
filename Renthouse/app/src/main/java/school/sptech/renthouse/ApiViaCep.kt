package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiViaCep {

    @GET("/{cep}/json")
    fun getDadosResidencia(@Path("cep") cep : String): Call<EnderecoViaCep>

}