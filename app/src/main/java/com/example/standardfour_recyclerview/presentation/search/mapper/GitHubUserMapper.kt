package com.example.standardfour_recyclerview.presentation.search.mapper

import com.example.standardfour_recyclerview.data.remote.GitHubUserListResponse
import com.example.standardfour_recyclerview.data.remote.GitHubUserResponse
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserEntity
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserListEntity

fun GitHubUserListResponse.toEntity() = GitHubUserListEntity(
    items = items.asGitHubUserEntity()
)

// 데이터클래스 맵핑
fun List<GitHubUserResponse>.asGitHubUserEntity() : List<GitHubUserEntity>{
    return map {
        GitHubUserEntity(
            it.avatarUrl,
            it.loginName,
            it.id
        )
    }
}
