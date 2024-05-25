//package com.example.standardfour_recyclerview.network
//import com.example.standardfour_recyclerview.data.remote.SearchRemoteDataSource
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
//

// Hilt를 사용함으로써 이런식으로 싱글톤형식으로 쓰지않음
//object RetrofitClient {
//    private const val BASE_URL = "https://api.github.com/"
//
//    // 네트워크 요청을 위한 httpClient 구성
//    private val okHttpClient by lazy {
//        OkHttpClient.Builder()
//            .build()
//    }
//
//
//    // retrofit 객체 초기화 및 생성
//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            // Gson으로 컨버팅
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    // Api Service 객체(SearchRemoteDataSource) 생성
//    val searchGitHubUser : SearchRemoteDataSource by lazy {
//        retrofit.create(SearchRemoteDataSource::class.java)
//    }
//
//}