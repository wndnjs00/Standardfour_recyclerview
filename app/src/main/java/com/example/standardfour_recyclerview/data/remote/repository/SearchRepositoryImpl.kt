package com.example.standardfour_recyclerview.data.remote.repository

import com.example.standardfour_recyclerview.presentation.repository.SearchRepository
import com.example.standardfour_recyclerview.data.remote.remote.SearchRemoteDataSource
import com.example.standardfour_recyclerview.presentation.search.mapper.toEntity
import javax.inject.Inject
import javax.inject.Singleton

// 레포지토리 구현부 (override해서 데이터구현부 실제구현)
// SearchRepository 상속받음

// 보통 데이터를 local, remote 영역으로 나눠서써줌 (지금예제에선 remote - remoteDataSource에 해당)
// @Inject constructor 추가 (remoteDataSource 파라미터로 Hilt주입시켜줌)
@Singleton
class SearchRepositoryImpl @Inject constructor (private val remoteDataSource : SearchRemoteDataSource) :
    SearchRepository {

    // SearchRepository에서 구현한 getGitHubUserList함수를 오버라이딩
    override suspend fun getGitHubUserList(q: String) =
        remoteDataSource.getGitHubUser(name = q).toEntity()
}