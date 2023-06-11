package school.sptech.renthouse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiItens {

    @GET("/itens/catalogo/{idUsuario}")
    fun getItensCatalogo(@Path("idUsuario") id: String): Call<List<CatalogoItem>>

    @POST("/itens")
    fun postItens(@Body body: RegisterItemRequest): Call<String>
    @POST("/negociacoes")
    fun negociacaoItens(@Body body: NegociationRequest): Call<String>

    @GET("/itens/usuario/{idUsuario}")
    fun myItensUser(@Path("idUsuario") id: String): Call<List<ItemUserProduct>>

    @GET("/negociacoes/usuario/{idUsuario}")
    fun myItensResquestUser(@Path("idUsuario") id: String): Call<List<ItemRequestedUser>>

    @GET("/itens/catalogo/item/{idItem}")
    fun getItemRent(@Path("idItem") id: String): Call<ItemRent>



    @GET("/itens/catalogo/{idUsuario}/nome/{nome}")
    fun myItensUser(@Path("idUsuario") id: String, @Path("nome") nome: String): Call<List<ItemUserProduct>>


}