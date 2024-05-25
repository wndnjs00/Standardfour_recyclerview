package com.example.standardfour_recyclerview.presentation.search.mapper

import com.example.standardfour_recyclerview.data.remote.model.GitHubUserListResponse
import com.example.standardfour_recyclerview.data.remote.model.GitHubUserResponse
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUser
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserList

// 서버 데이터를 data class로 mapping
// mapping하면 DTO class의 구조나 필드가 변경되어도, 실제 Domain class에는 영향미치지X


// GitHubUserResponse 객체를 GitHubUserEntity 객체로 변환하는 함수
fun GitHubUserListResponse.toEntity() = GitHubUserList(
    items = items.asGitHubUserEntity()
)


// GitHubUserResponse 객체들의 리스트를 GitHubUserEntity 객체들의 리스트로 변환하는 함수
fun List<GitHubUserResponse>.asGitHubUserEntity() : List<GitHubUser>{
    return map {
        GitHubUser(
            it.avatarUrl,
            it.loginName,
            it.id
        )
    }
}
