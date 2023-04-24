package school.sptech.renthouse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Apis {

    var BASE_URL = "http://10.0.2.2:8080"
    var URL_VIACEP = "https://viacep.com.br/ws/"

    fun getApiUsuarios(): ApiUsuarios {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuarios::class.java)
    }

    fun getApiViaCep(): ApiViaCep{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL_VIACEP)
            .build()
        return retrofit.create(ApiViaCep::class.java)
    }

    fun apiCarteira(): ApiCarteira {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiCarteira::class.java)
    }

}