package com.plcoding.dictionary.dictonary_feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.dictionary.dictonary_feature.domain.model.Meaning
import com.plcoding.dictionary.dictonary_feature.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String,
    @PrimaryKey
    val id:Int?=null
){
    fun toWordInfo():WordInfo{
        return WordInfo(
            meanings = meanings,
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}
