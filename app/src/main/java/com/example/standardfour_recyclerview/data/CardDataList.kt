package com.example.standardfour_recyclerview.data

fun CardDataList() : ArrayList<CardData>{

    return arrayListOf(
        CardData(
            name = "Juwon",
            cardName = "A Debit Card",
            number = 242335819503,
            date = "21/27",
            price = 310030,
            type = 1
        ),
        CardData(
            name = "Minju",
            cardName = "A Hibrid Card",
            number = 542335819503,
            date = "07/25",
            price = 410030,
            type = 2
        ),
        CardData(
            name = "Hemin",
            cardName = "A Hi Card",
            number = 942335819503,
            date = "23/29",
            price = 417030,
            type = 3
        ),
    )

}