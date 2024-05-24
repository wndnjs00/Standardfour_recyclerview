package com.example.standardfour_recyclerview.presentation.search.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserEntity

// sharedViewModel사용해서 프레그먼트간 viewModel공유
class GitHubUserSharedViewModel : ViewModel(){

    private val _favoriteLiveData = MutableLiveData<List<GitHubUserEntity>>()
    val favoriteLiveData : LiveData<List<GitHubUserEntity>> = _favoriteLiveData

    fun setFavoriteList(list : List<GitHubUserEntity>){
        // 얘는 좋아요한 데이터만 가지고있음
        _favoriteLiveData.value = list
    }
}