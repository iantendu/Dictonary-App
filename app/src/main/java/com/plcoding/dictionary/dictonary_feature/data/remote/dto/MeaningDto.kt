package com.plcoding.dictionary.dictonary_feature.data.remote.dto

import com.plcoding.dictionary.dictonary_feature.domain.model.Meaning


data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
){
    fun toMeaning():Meaning{
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}