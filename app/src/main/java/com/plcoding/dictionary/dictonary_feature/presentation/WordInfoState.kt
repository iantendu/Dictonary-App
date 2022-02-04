package com.plcoding.dictionary.dictonary_feature.presentation


import com.plcoding.dictionary.dictonary_feature.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems:List<WordInfo> = emptyList(),
    val isLoading:Boolean=false

)