package www.uzmd.learningpatoc.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCilent {
   const val BASE_URL="https://stile.uz/";

    fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}