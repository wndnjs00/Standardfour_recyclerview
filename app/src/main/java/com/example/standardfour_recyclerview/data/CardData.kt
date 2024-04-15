package com.example.standardfour_recyclerview.data

data class CardData(
    val name : String,      //이름
    val cardName : String,  //카드이름 (A Debit Card)
    val number : Long,       //카드번호
    val date : String,      //유효기간
    val price : Long,        //가격

    val type : Int          //멀티뷰타입
)
