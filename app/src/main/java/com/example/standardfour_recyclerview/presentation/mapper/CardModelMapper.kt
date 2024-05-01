package com.example.standardfour_recyclerview.presentation.mapper

import com.example.standardfour_recyclerview.data.entity.CardEntity
import com.example.standardfour_recyclerview.presentation.model.CardModel


// getCardList는 CardEntity인데, SearchRepository는 CardModel이니깐 타입을 바꿔줘야함 (mapping시켜주기)
// 추후 DTO, DAO, Entity등 domain layer, presentation layer에 필요한 model만 data class에서 mapping해서 쓸 용도
fun List<CardEntity>.asCardModel() : List<CardModel> {
    return map{
        CardModel(
            it.id,
            it.name,
            it.cardName,
            it.number,
            it.date,
            it.price,
            it.type
        )

    }
}