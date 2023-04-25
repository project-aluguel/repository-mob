package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiItens {

    @GET()
    fun login(@Body body: String): Call<ItemRequest>
}