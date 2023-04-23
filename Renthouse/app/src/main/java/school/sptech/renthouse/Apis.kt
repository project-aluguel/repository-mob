package school.sptech.renthouse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Apis {

    var BASE_URL = ""

    fun getApiUsuarios(): ApiUsuarios {
        BASE_URL = "http://10.18.7.9:8080/usuarios/"
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuarios::class.java)
    }

    fun getApiItens(): ApiItens {
        BASE_URL = "http://10.18.7.9:8080/itens/usuarios/"
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuarios::class.java)
    }
}