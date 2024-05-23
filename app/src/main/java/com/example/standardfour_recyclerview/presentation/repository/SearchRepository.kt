package com.example.standardfour_recyclerview.presentation.repository

import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserListEntity

// Repository pattern 사용 -> Data layer에 대한 의존성 줄일수있음
// Repository pattern은 ViewModel에서 데이터를 호출하는 부분에서 사용!!
interface SearchRepository {


    // query(q) 로 cindy값 넣어준 부분을 얘기하는것
    suspend fun getGitHubUserList(userName : String) : GitHubUserListEntity
}