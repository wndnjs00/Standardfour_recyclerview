package com.example.standardfour_recyclerview.presentation.search.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.standardfour_recyclerview.data.repository.SearchRepositoryImpl
import com.example.standardfour_recyclerview.network.RetrofitClient
import com.example.standardfour_recyclerview.presentation.repository.SearchRepository
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserEntity
import kotlinx.coroutines.launch


// ViewModel에서는 직접적으로 데이터에 접근하지 않고, Repository를 통해서 데이터접근해서 데이터호출 (private val searchRepository: SearchRepository)
class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel(){
    // LiveData 사용
    private val _getGitHubUserList : MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val getGitHubUserList : LiveData<List<GitHubUserEntity>> get() = _getGitHubUserList

    fun getGitHubUserList() = viewModelScope.launch {
        // "cindy" 검색값 붙잡고있음
        _getGitHubUserList.value = searchRepository.getGitHubUserList("cindy").items
    }


    // sharedViewModel에 뿌려줄 라이브데이터 세팅
    private val _favoriteUserList : MutableLiveData<List<GitHubUserEntity>> = MutableLiveData()
    val favoriteUserList : LiveData<List<GitHubUserEntity>> get() = _favoriteUserList


    // 좋아요한 값만 가져오는 함수
    fun setFavoriteItem(item : GitHubUserEntity){
        // gitHubUserList변수에 라이브데이터에 세팅된 값이 담김(cindy 검색값이 담김)
        //toMutableList 수정가능 한 List로 변경
        val gitHubUserList = _getGitHubUserList.value!!.toMutableList()

        //매칭된 아이템의 index를 반환
        val position = gitHubUserList.indexOfFirst {
            it.id == item.id
        }

        // 좋아요 상태값 넣어줌
        _getGitHubUserList.value =
        //livedata에서 받아온 list를 index으로 sorting해서 data class copy함 (data class의 객체를 복사)
        gitHubUserList.also {
            it[position] = item.copy(
                //bool 값을 반대값 세팅 (isFavorite이 ture이면 false로, false이면 true로)
                isFavorite = !item.isFavorite
            )
        }

        // 좋아요한 목록만(좋아요가 true인값만) 필터링해서 넣어줌!!
        _favoriteUserList.value = gitHubUserList.filter {
            it.isFavorite
        }

    }

}

class SearchViewModelFactory : ViewModelProvider.Factory{
    private val repository = SearchRepositoryImpl(RetrofitClient.searchGitHubUser)

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
        ): T {
        return SearchViewModel(repository) as T
    }
}

