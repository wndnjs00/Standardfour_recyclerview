package com.example.standardfour_recyclerview.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.standardfour_recyclerview.data.database.entity.FavoriteUserEntity

@Dao
interface FavoriteDao {

    // FavoriteUserEntity 전체를 Insert(삽입)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoriteUser : FavoriteUserEntity)


    // 전체 데이터 가져옴
    @Query("SELECT * FROM FavoriteUserEntity")
    suspend fun getAll() : List<FavoriteUserEntity>   // 좋아요된값 리스트로 가져오게히기위해서 List에 담음
}