package com.example.standardfour_recyclerview.data.database


// 싱글톤
object DataSource {

    // MVVM패턴에서 Model에 해당한다고 볼 수 있음
    fun getCardList() : List<CardEntity>{
        // 만들어놓은 데이터클래스 리턴
        return CardDataList()
    }

}