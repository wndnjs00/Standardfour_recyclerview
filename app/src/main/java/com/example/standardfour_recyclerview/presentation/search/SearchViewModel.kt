package com.example.standardfour_recyclerview.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.standardfour_recyclerview.data.database.DataSource
import com.example.standardfour_recyclerview.data.repository.SearchRepositoryImpl
import com.example.standardfour_recyclerview.network.RetrofitClient
import com.example.standardfour_recyclerview.presentation.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel(){
    // LiveData 사용
    private val _getGitHubUserList : MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val getGitHubUserList : LiveData<List<GitHubUserEntity>> get() = _getGitHubUserList

    fun getGitHubUserList() = viewModelScope.launch {
        _getGitHubUserList.value = searchRepository.getGitHubUserList("cindy").items
    }
}

class SearchViewModelFactory : ViewModelProvider.Factory{
    private val repository = SearchRepositoryImpl(DataSource, RetrofitClient.searchGitHubUser)

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
        ): T {
        return SearchViewModel(repository) as T
    }
}