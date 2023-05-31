package school.sptech.renthouse

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Apis {

    val okHttpClient = OkHttpClient.Builder()
        .build()

    var BASE_URL = "http://renthouse-app.duckdns.org:8080"
    var URL_VIACEP = "http://viacep.com.br/ws/"

    fun getApiUsuarios(): ApiUsuarios {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
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
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiCarteira::class.java)
    }


    fun getApiItens(): ApiItens {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiItens::class.java)
    }



}