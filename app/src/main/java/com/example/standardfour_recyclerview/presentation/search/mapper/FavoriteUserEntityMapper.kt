package com.example.standardfour_recyclerview.presentation.search.mapper

import com.example.standardfour_recyclerview.data.database.entity.FavoriteUserEntity
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUser


// presentation layer -> data layer 매핑 (여태해온방식은 data layer -> presentation layer 매핑방식)

// presentation layer(searchViewModel)에서는 GithubUser로 쓰고있는데,
// CacheRepository에서는 FavoriteUserEntity 사용하고있음 (각자 다른 데이터 쓰고있기때문에 mapping해줄거임)

fun GitHubUser.asFavoriteUserEntity() : FavoriteUserEntity {
    return FavoriteUserEntity(
        avatarUrl = avatarUrl,
        loginName = loginName,
        id = id,
        isFavorate = isFavorite
    )
}