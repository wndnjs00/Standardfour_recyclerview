package com.example.standardfour_recyclerview.data.remote.di

import com.example.standardfour_recyclerview.data.remote.SearchRemoteDataSource
import com.example.standardfour_recyclerview.network.HttpRequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private const val BASE_URL = "https://api.github.com/"

@Module
@InstallIn(SingletonComponent::class)   // 앱 전체에서 사용할 모듈이기 때문에 SingletonComponent로 설정
object RetrofitClient {

    //@Provides : room, retrofit과 같은 외부 라이브러리에서 제공되는 클래스여서 프로젝트 내에서 소유할 수 없는 경우 or builder 패턴을 통해 인스턴스를 생성해야 하는 경우 사용
    //@Provides 어노테이션이 달린 함수는 return값이 있어야함 (return 유형은 함수가 어떤 유형의 인스턴스를 제공하는지 Hilt에 알려줘야함)
    @Provides
    @Singleton
    // 네트워크 요청을 위한 httpClient 구성
    fun providesOkHttpClient() : OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(HttpRequestInterceptor())   // 만들어준 HttpRequestInterceptor() 넣어줌
            .addNetworkInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    // retrofit 객체 초기화 및 생성
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            // Gson으로 컨버팅
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    // Api Service 객체(SearchRemoteDataSource) 생성
    fun provideSearchRemoteDataSource(retrofit: Retrofit): SearchRemoteDataSource {

        return retrofit.create(SearchRemoteDataSource::class.java)
    }

}