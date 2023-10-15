package www.uzmd.learningpatoc.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSevices {
    @GET("ytVideoToMusic/api.php")
    fun getMusicUrl(@Query("url") url:String): Call<Model>
}