package com.plcoding.dictionary.dictonary_feature.data.remote.dto

import com.plcoding.dictionary.dictonary_feature.domain.model.Meaning
import com.plcoding.dictionary.dictonary_feature.domain.model.WordInfo


data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
){
    fun toWordInfo(): WordInfo {
        return WordInfo(
         meanings = meanings.map { it.toMeaning() },
         origin = origin,
         phonetic = phonetic,
         word = word
        )
    }
}