package com.example.standardfour_recyclerview.presentation.repository

import com.example.standardfour_recyclerview.presentation.model.CardModel

interface SearchRepository {
    fun getCardList() : List<CardModel>
}