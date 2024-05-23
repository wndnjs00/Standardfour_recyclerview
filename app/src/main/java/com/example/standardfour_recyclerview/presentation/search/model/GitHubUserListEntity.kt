package com.example.standardfour_recyclerview.presentation.search.model


// GitHubUserListResponse를 어노테이션만 뺴고 그대로 가져온것
// 서버 데이터를 data class로 mapping
data class GitHubUserListEntity(
    val items : List<GitHubUserEntity>
)

data class GitHubUserEntity(
    val avatarUrl : String,
    val loginName : String,
    val id : Int,
    val isFavorite : Boolean = false,   // 좋아요표시
)