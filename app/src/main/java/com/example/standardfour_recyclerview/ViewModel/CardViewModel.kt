package com.example.standardfour_recyclerview.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.data.DataSource

class CardViewModel(dataSource: DataSource) : ViewModel() {

    // data list observing을 사용하는 방법! (LiveData 사용안하고)
    val cardData = dataSource.getCardList()

    fun getCardModel(cardData: CardData) : CardData{
        return cardData
    }
}


class CardViewModelFactory : ViewModelProvider.Factory{

    // 어떤 타입의 뷰모델이 와도 가능하게끔 (데이터타입도 어떤 데이터타입이든지 가능하도록)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        // modelClass(FlowerViewModel)가 유효한지 검사 (값이 있는지 체크)
        // 즉, CardViewModel::class.java가 modelClass와 동일한 클래스인지를 검사
        if (modelClass.isAssignableFrom(CardViewModel::class.java)){
            // 값이 있다면, FlowerViewModel객체를 생성 / 이때, FlowerViewModel은 dataSource를 인자로 받아 초기화된다
            // CardViewModel을 제네릭T타입으로 바꿔주겠다
            return CardViewModel(dataSource = DataSource.getDataSoures()) as T
        }

        throw IllegalAccessException("Unknown ViewModel Class")
    }
}