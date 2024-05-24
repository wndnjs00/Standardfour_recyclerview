package com.example.standardfour_recyclerview.data.repository

import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserListEntity

// Repository pattern 사용 -> Data layer에 대한 의존성 줄일수있음
// Repository pattern은 ViewModel에서 데이터를 호출하는 부분에서 사용!!
interface SearchRepository {

    // getGitHubUserList는 viewModel에서 코루틴스코프를 통해서 호출할것이기 때문에 suspend fun으로 호출!
    suspend fun getGitHubUserList(q : String) : GitHubUserListEntity
}