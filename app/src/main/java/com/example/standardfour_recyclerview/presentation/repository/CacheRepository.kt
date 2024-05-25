package com.example.standardfour_recyclerview.presentation.repository

import com.example.standardfour_recyclerview.data.database.entity.FavoriteUserEntity

interface CacheRepository {
    suspend fun insertGitHubUser(favoriteUserEntity : FavoriteUserEntity)
}