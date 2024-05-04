package com.example.standardfour_recyclerview.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.standardfour_recyclerview.data.repository.SearchRepositoryImpl
import com.example.standardfour_recyclerview.data.database.DataSource
import com.example.standardfour_recyclerview.presentation.repository.SearchRepository
import com.example.standardfour_recyclerview.presentation.model.CardModel

class CardViewModel(private val searchRepository : SearchRepository) : ViewModel() {

    //liveData를 외부에서 수정할 수 없도록 하고, ViewModel을 통해서만 데이터를 업데이트 하고 observing 하도록 함
    //실제 데이터를 저장하고 있는 MutableLiveData
    //_getBlueCardModel을 private로 선언함으로써, ViewModel외부에서 이 데이터를 직접적으로 접근할 수 없음
    private val _getBlueCardModel : MutableLiveData<List<CardModel>> = MutableLiveData()

    // Activity에서 가져울 수 있도록 따로 변수지정
    // LiveData 객체 생성
    //_getBlueCardModel의 public getter()이며 외부에서 liveData를 읽을 수 있는 접근자
    val getBlueCardModel : LiveData<List<CardModel>> get() = _getBlueCardModel


    fun getBlueCardModel() {
        _getBlueCardModel.value = searchRepository.getCardList()
    }

}


class CardViewModelFactory : ViewModelProvider.Factory{

    // 어떤 타입의 뷰모델이 와도 가능하게끔 (데이터타입도 어떤 데이터타입이든지 가능하도록)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return CardViewModel(SearchRepositoryImpl(DataSource)) as T

    }
}