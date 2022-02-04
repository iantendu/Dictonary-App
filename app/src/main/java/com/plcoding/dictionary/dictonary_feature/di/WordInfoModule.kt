package com.plcoding.dictionary.dictonary_feature.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.plcoding.dictionary.core.util.Constants
import com.plcoding.dictionary.dictonary_feature.data.local.Converters
import com.plcoding.dictionary.dictonary_feature.data.local.WordInfoDao
import com.plcoding.dictionary.dictonary_feature.data.local.WordInfoDatabase
import com.plcoding.dictionary.dictonary_feature.data.remote.DictonaryApi
import com.plcoding.dictionary.dictonary_feature.data.repository.WordInfoRepositoryImpl
import com.plcoding.dictionary.dictonary_feature.data.util.GsonParser
import com.plcoding.dictionary.dictonary_feature.domain.repository.WordInfoRepository
import com.plcoding.dictionary.dictonary_feature.domain.usecases.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictonaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictonaryApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictonaryApi::class.java)
    }
}