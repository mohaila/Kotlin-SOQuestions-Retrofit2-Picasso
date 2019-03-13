package ca.qc.mtl.mohaila.kotlinsoquestionsretrofit2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SOQuestionsInterface {
    @GET("/2.1/questions?order=desc&sort=creation&site=stackoverflow&tagged=kotlin")
    fun getQuestions(): Call<Questions>

    companion object Factory {
        fun create(): SOQuestionsInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(SOQuestionsInterface::class.java)
        }

        private const val BASE_URL = "https://api.stackexchange.com"
    }
}