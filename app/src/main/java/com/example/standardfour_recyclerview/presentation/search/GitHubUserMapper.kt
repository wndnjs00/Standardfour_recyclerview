package com.example.standardfour_recyclerview.presentation.search

import com.example.standardfour_recyclerview.data.remote.GitHubUserListResponse
import com.example.standardfour_recyclerview.data.remote.GitHubUserResponse

fun GitHubUserListResponse.toEntity() = GitHubUserListEntity(
    items = items.asGitHubUserEntity()
)

fun List<GitHubUserResponse>.asGitHubUserEntity() : List<GitHubUserEntity>{
    return map {
        GitHubUserEntity(
            it.avatarUrl,
            it.loginName
        )
    }
}
