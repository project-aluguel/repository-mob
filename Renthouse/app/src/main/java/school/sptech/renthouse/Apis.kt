package school.sptech.renthouse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apis {

    var BASE_URL = "http://10.18.7.9:8080/usuarios/"

    fun getApiUsuarios(): ApiUsuarios {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuarios::class.java)
    }

    fun apiCarteira() : ApiCarteira{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/")
            .build()
        return retrofit.create(ApiCarteira::class.java)
    }
}