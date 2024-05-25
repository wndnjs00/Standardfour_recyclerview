package com.example.standardfour_recyclerview.data.remote.di

import com.example.standardfour_recyclerview.presentation.repository.SearchRepository
import com.example.standardfour_recyclerview.data.remote.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Repository생성할때마다 Module코드 작성해줘야함
@Module
@InstallIn(SingletonComponent::class)   // 앱 전체에서 사용할 모듈이기 때문에 SingletonComponent로 설정
abstract class SearchRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl) : SearchRepository
}