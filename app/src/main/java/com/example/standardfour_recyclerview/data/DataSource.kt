package com.example.standardfour_recyclerview.data


// 싱글톤
class DataSource {
    companion object{
        private var INSTANCE : DataSource? = null

        fun getDataSoures() : DataSource{
            // DatoSource::class 객체에 lock을 걸어 한번에 한 스레드에서만 실행 되도록 함
            return synchronized(DataSource::class) {
                // 싱글톤 객체를 한번 호출하고 없으면 DataSource반환, 있으면 생성된 인스턴스 반환
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList() : ArrayList<CardData>{
        // 만들어놓은 데이터클래스 리턴
        return CardDataList()
    }



}