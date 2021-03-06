package com.plcoding.dictionary.dictonary_feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plcoding.dictionary.dictonary_feature.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase:RoomDatabase() {
    abstract val dao:WordInfoDao

    companion object{
        const val DATABASE_NAME="wordinfo_db"
    }
}