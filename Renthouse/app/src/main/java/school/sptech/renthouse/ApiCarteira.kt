package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCarteira {

    @GET("carteiras/{idUsuario}")
    fun buscaCarteira(@Path("idUsuario") idUsuario: String): Call<CarteiraUsuario>

    @PUT("carteiras/{idCarteira}")
    fun recarregaCarteira(@Path("idCarteira") idCarteira: String, @Body body: RecargaCarteira ): Call<CarteiraUsuario>


}