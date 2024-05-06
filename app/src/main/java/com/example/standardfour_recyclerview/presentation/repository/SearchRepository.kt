package com.example.standardfour_recyclerview.presentation.repository

import com.example.standardfour_recyclerview.presentation.model.CardModel
import com.example.standardfour_recyclerview.presentation.search.GitHubUserEntity
import com.example.standardfour_recyclerview.presentation.search.GitHubUserListEntity

interface SearchRepository {
    fun getCardList() : List<CardModel>


    // query(q) 로 cindy값 넣어준 부분을 얘기하는것
    suspend fun getGitHubUserList(userName : String) : GitHubUserListEntity
}