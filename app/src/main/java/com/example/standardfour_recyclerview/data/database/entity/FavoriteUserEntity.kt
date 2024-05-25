package com.example.standardfour_recyclerview.data.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class FavoriteUserEntity(
    @PrimaryKey(autoGenerate = true) val uId : Int = 0,
    val avatarUrl : String,
    val loginName : String,
    val id : Int,
    val isFavorate : Boolean = false

): Parcelable