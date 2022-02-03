package com.plcoding.dictionary.dictonary_feature.domain.model

import com.plcoding.dictionary.dictonary_feature.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)
