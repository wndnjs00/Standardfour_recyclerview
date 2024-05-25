package com.example.standardfour_recyclerview.data.remote.retrofit

import okhttp3.Interceptor
import okhttp3.Response

// internal class가 뭔지 찾아보기
internal class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //캐싱된 token값을 가져온다면?
        //val token : String? = runBlocking { userDataStore.getToken() }
        return chain.proceed(
            chain.request()
                .newBuilder()
                .run {
                    //Token 필요할 시 여기에 넣기! 이렇게 하면 call할 때마다 @Header 추가 안해줘도됨.
                    //this.addHeader("Token", token)
                    this.addHeader("Token", "Bearer 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")
                }
                .build()
        )
    }

}