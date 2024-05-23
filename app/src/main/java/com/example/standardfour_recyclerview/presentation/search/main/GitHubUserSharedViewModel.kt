package com.example.standardfour_recyclerview.presentation.search.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserEntity

// sharedViewModel사용해서 프레그먼트간 viewModel공유
class GitHubUserSharedViewModel : ViewModel(){

    private val _favoriteLiveData = MutableLiveData<List<GitHubUserEntity>>()
    val favoriteLiveData : LiveData<List<GitHubUserEntity>> = _favoriteLiveData

    fun setFavoriteList(list : List<GitHubUserEntity>){
        _favoriteLiveData.value = list
    }
}


// ViewModelFactory 생성
//class GitHubUserViewModelFactory : ViewModelProvider.Factory{
//    private val repository = SearchRepositoryImpl(DataSource, RetrofitClient.searchGitHubUser)
//
//    override fun <T : ViewModel> create(
//        modelClass: Class<T>,
//        extras: CreationExtras
//        ): T {
//            return GitHubUserSharedViewModel as T
//    }
//}