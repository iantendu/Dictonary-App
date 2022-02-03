package com.plcoding.dictionary.dictonary_feature.domain.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.dictonary_feature.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word:String):Flow<Resource<List<WordInfo>>>
}