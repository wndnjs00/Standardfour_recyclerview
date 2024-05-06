package com.example.standardfour_recyclerview.data.database

import com.example.standardfour_recyclerview.presentation.main.MultiViewEnum

data class CardEntity(
    val id : Int,
    val name : String,       //이름
    val cardName : String,   //카드이름
    val number : String,     //카드번호
    val date : String,       //유효기간
    val price : Double,      //가격
    val type : MultiViewEnum   // 멀티뷰타입 -> enum class로 만든 클래스 선언
)