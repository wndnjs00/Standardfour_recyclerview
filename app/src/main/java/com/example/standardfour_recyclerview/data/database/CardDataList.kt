package com.example.standardfour_recyclerview.data.database

import com.example.standardfour_recyclerview.data.entity.CardEntity
import com.example.standardfour_recyclerview.presentation.enums.MultiViewEnum

//network or cache data로 변경될 예정
//DTO(서버로 부터 오는 json) or DAO(database)
fun CardDataList() : ArrayList<CardEntity>{

    return arrayListOf(
        CardEntity(
            id = 1,
            name = "Juwon",
            cardName = "A Debit Card",
            number = "2423 3581 9503",
            date = "21/27",
            price = 3100.30,
            MultiViewEnum.BlUE
        ),
        CardEntity(
            id = 2,
            name = "Minju",
            cardName = "A Hybrid Card",
            number = "5423 3581 9503",
            date = "07/25",
            price = 4100.30,
            MultiViewEnum.LIGHTBLUE
        ),
        CardEntity(
            id = 3,
            name = "Hemin",
            cardName = "A Hi Card",
            number = "9423 3581 9503",
            date = "23/29",
            price = 4170.30,
            MultiViewEnum.ORANGE
        ),
        CardEntity(
            id = 4,
            name = "Anderson",
            cardName = "A Debit Card",
            number = "2423 3581 9503",
            date = "21/27",
            price = 3100.30,
            MultiViewEnum.BlUE
        ),
        CardEntity(
            id = 5,
            name = "Jimmy",
            cardName = "A Hybrid Card",
            number = "5423 3581 9503",
            date = "07/25",
            price = 4100.30,
            MultiViewEnum.LIGHTBLUE
        ),
        CardEntity(
            id = 6,
            name = "Hanna",
            cardName = "A Hi Card",
            number = "9423 3581 9503",
            date = "23/29",
            price = 4170.30,
            MultiViewEnum.ORANGE
        ),
        CardEntity(
            id = 7,
            name = "miju",
            cardName = "A Hybrid Card",
            number = "5423 3581 9503",
            date = "07/25",
            price = 4100.30,
            MultiViewEnum.LIGHTBLUE
        )
    )

}