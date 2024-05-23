package com.example.standardfour_recyclerview.data.repository

import com.example.standardfour_recyclerview.data.database.DataSource
import com.example.standardfour_recyclerview.data.remote.SearchRemoteDataSource
import com.example.standardfour_recyclerview.presentation.repository.SearchRepository
import com.example.standardfour_recyclerview.presentation.mapper.asCardModel
import com.example.standardfour_recyclerview.presentation.search.mapper.toEntity
import com.example.standardfour_recyclerview.presentation.model.CardModel

//interface인 repository를 구현함으로써 dataSource의 data를 가져옴
//repository -> dataSource의 의존성 회피
//의존을 없애면 datasource변경(network->database)시 repository에 영향 x

// private val remoteDataSource : SearchRemoteDataSource 추가
class SearchRepositoryImpl(private val dataSource : DataSource, private val remoteDataSource : SearchRemoteDataSource) : SearchRepository {
    override fun getCardList(): List<CardModel> {

        // CardModel로 타입을 바꿔줘야함 (mapping시켜주기) - CardModelMapper에서
        return dataSource.getCardList().asCardModel()
    }

    override suspend fun getGitHubUserList(userName: String) =
        remoteDataSource.getGitHubUser(userName).toEntity()
}