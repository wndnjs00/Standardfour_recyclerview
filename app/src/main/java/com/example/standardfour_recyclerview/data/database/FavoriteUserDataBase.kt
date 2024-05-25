package com.example.standardfour_recyclerview.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.standardfour_recyclerview.data.database.FavoriteDao
import com.example.standardfour_recyclerview.data.database.entity.FavoriteUserEntity

// 배포됐을때- FavoriteUserEntity 변경될때마다 버전 올려줘야함 (배포안한앱이면 걍 앱삭제하고 재실행)
@Database(entities = [FavoriteUserEntity::class], version = 1)
abstract class FavoriteUserDataBase : RoomDatabase(){
    abstract fun favoriteDao() : FavoriteDao
}