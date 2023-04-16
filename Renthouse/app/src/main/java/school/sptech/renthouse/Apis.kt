package school.sptech.renthouse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Apis {

    var BASE_URL = "http://192.168.0.32:8080/usuarios/"

    fun getApiUsuarios(): ApiUsuarios {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuarios::class.java)
    }
}