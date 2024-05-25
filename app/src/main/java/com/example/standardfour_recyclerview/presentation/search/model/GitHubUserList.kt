package com.example.standardfour_recyclerview.presentation.search.model


// GitHubUserListResponse변수를 어노테이션만 뺴고 그대로 가져온것
// 실제로 사용할 데이터클래스!!
data class GitHubUserList(
    val items : List<GitHubUser>
)

data class GitHubUser(
    val avatarUrl : String,
    val loginName : String,
    val id : Int,
    val isFavorite : Boolean = false,   // 좋아요표시
)