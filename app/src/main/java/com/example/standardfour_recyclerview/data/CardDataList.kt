package com.example.standardfour_recyclerview.data

fun CardDataList() : ArrayList<CardData>{

    return arrayListOf(
        CardData(
            name = "Juwon",
            cardName = "A Debit Card",
            number = "2423 3581 9503",
            date = "21/27",
            price = 3100.30,
            type = 1
        ),
        CardData(
            name = "Minju",
            cardName = "A Hibrid Card",
            number = "5423 3581 9503",
            date = "07/25",
            price = 4100.30,
            type = 2
        ),
        CardData(
            name = "Hemin",
            cardName = "A Hi Card",
            number = "9423 3581 9503",
            date = "23/29",
            price = 4170.30,
            type = 3
        ),
    )

}