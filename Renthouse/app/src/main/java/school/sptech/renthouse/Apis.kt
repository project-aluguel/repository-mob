package school.sptech.renthouse

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Apis {

    val okHttpClient = OkHttpClient.Builder()
        .build()

    var BASE_URL = "http://renthouse-app.duckdns.org:8080"
    var URL_VIACEP = "http://viacep.com.br/ws/"

    val gsonBuilder = GsonBuilder().setLenient()
    val gson = gsonBuilder.create()

    fun getApiUsuarios(): ApiUsuarios {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiUsuarios::class.java)
    }

    fun getApiViaCep(): ApiViaCep{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL_VIACEP)
            .build()
        return retrofit.create(ApiViaCep::class.java)
    }

    fun apiCarteira(): ApiCarteira {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiCarteira::class.java)
    }


    fun getApiItens(): ApiItens {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiItens::class.java)
    }



}