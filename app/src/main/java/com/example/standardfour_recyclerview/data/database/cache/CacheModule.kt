package com.example.standardfour_recyclerview.data.database.cache

import com.example.standardfour_recyclerview.presentation.repository.CacheRepository
import com.example.standardfour_recyclerview.data.remote.repository.UserCacheRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Repository생성할때마다 Module코드 작성해줘야함
@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    @Singleton
    abstract fun bindsUserCacheRepository(userCacheRepositoryImpl: UserCacheRepositoryImpl) : CacheRepository
}