package com.example.standardfour_recyclerview.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CardData(
    val name : String,       //이름
    val cardName : String,   //카드이름
    val number : String,     //카드번호
    val date : String,       //유효기간
    val price : Double,      //가격

    val type : Int           //멀티뷰타입
): Parcelable
