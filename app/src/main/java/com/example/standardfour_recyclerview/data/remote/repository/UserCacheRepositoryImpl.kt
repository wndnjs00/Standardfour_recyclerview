package com.example.standardfour_recyclerview.data.remote.repository

import com.example.standardfour_recyclerview.presentation.repository.CacheRepository
import com.example.standardfour_recyclerview.data.database.FavoriteDao
import com.example.standardfour_recyclerview.data.database.entity.FavoriteUserEntity
import javax.inject.Inject

// CacheRepository 레포지토리 구현체
class UserCacheRepositoryImpl @Inject constructor(private val favoriteDao: FavoriteDao) : CacheRepository {
    override suspend fun insertGitHubUser(favoriteUserEntity: FavoriteUserEntity) {
        return favoriteDao.insertFavorite(favoriteUserEntity)
    }

}