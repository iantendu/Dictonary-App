package com.plcoding.dictionary.dictonary_feature.domain.model

import com.plcoding.dictionary.dictonary_feature.data.remote.dto.MeaningDto
import com.plcoding.dictionary.dictonary_feature.data.remote.dto.PhoneticDto

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
