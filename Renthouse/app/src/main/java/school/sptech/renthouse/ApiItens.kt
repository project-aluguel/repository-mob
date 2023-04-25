package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiItens {

    @GET("{id}")
    fun getItens(@Path("id") id: String): Call<ItemRequest>
}