package com.moviedb.moviedb.services


import com.moviedb.moviedb.app.moviebaseURL
import com.moviedb.moviedb.model.Movie
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query


interface ApiService {
    @GET("popular")  //check end point
    suspend fun getMovies(@Query("api_key") apiKey: String): List<Movie>
}
//To get popular movies
//https://api.themoviedb.org/3/movie/popular
//To get Details
//https://api.themoviedb.org/3/movie/{movie_id}
object RetrofitInstance {
    private const val BASE_URL = moviebaseURL // Replace with your API base URL
//    private const val BASE_URL = "https://api.example.com/" // Replace with your API base URL

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
///
///
//interface ApiService {
//    @GET("your-endpoint")
//    fun getData(@Query("api_key") apiKey: String): Call<ApiResponse>
//}
//
//val retrofit = Retrofit.Builder()
//    .baseUrl("https://api.example.com/") // Replace with your API base URL
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//
//val apiService = retrofit.create(ApiService::class.java)
//val call = apiService.getData("YOUR_API_KEY")
//call.enqueue(object : Callback<ApiResponse> {
//    override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
//        if (response.isSuccessful) {
//            val apiResponse = response.body()
//            // Handle the response
//            println("Data: ${apiResponse?.name}")
//        } else {
//            // Handle the error
//            println("Error: ${response.errorBody()}")
//        }
//    }
//
//    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//        // Handle the failure
//        println("Failure: ${t.message}")
//    }
//})