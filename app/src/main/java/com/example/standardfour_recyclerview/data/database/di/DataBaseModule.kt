package com.example.standardfour_recyclerview.data.database.di

import android.app.Application
import androidx.room.Room
import com.example.standardfour_recyclerview.data.database.FavoriteDao
import com.example.standardfour_recyclerview.data.database.FavoriteUserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// Room에도 Hilt적용시키는 코드!!

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    fun providesFavoriteUserDatabase(application: Application) : FavoriteUserDataBase {
        return Room.databaseBuilder(
            application,
            FavoriteUserDataBase::class.java,
            name = "FavoriteUserDataBase"
        ).build()
    }

    // Dao에 대한 Hilt 의존성도 추가
    @Provides
    fun ProvidesFavorieDao(appDataBase: FavoriteUserDataBase) : FavoriteDao {
        return appDataBase.favoriteDao()
    }
}