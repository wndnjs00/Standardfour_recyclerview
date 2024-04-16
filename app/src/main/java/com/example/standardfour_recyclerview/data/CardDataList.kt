package com.example.standardfour_recyclerview.data

import com.example.standardfour_recyclerview.presentation.enums.MultiViewEnum

fun CardDataList() : ArrayList<CardData>{

    return arrayListOf(
        CardData(
            id = 1,
            name = "Juwon",
            cardName = "A Debit Card",
            number = "2423 3581 9503",
            date = "21/27",
            price = 3100.30,
            MultiViewEnum.MULTI_VIEWTYPE1
        ),
        CardData(
            id = 2,
            name = "Minju",
            cardName = "A Hybrid Card",
            number = "5423 3581 9503",
            date = "07/25",
            price = 4100.30,
            MultiViewEnum.MULTI_VIEWTYPE2
        ),
        CardData(
            id = 3,
            name = "Hemin",
            cardName = "A Hi Card",
            number = "9423 3581 9503",
            date = "23/29",
            price = 4170.30,
            MultiViewEnum.MULTI_VIEWTYPE3
        ),
    )

}