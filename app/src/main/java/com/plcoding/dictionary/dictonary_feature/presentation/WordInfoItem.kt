package com.plcoding.dictionary.dictonary_feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.dictonary_feature.domain.model.WordInfo

@Composable

fun WordInfoItem(
    wordInfo: WordInfo,
    modifier:Modifier=Modifier

    ){
    Column(
        modifier = modifier
    ) {
        Text(
            text =wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(text = wordInfo.phonetic, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = wordInfo.origin)
        wordInfo.meanings.forEach { meaning ->
        Text(text = meaning.partOfSpeech, fontWeight = FontWeight.Bold)
        meaning.definitions.forEachIndexed{index, definition ->
            Text(text = "${index+1}. ${definition.definition}")
            Spacer(modifier = modifier.height(16.dp))
            definition.example?.let { example->
                Text(text = "Example: ${example}")

            }
            Spacer(modifier = modifier.height(8.dp))
        }
            Spacer(modifier = modifier.height(16.dp))
        }

    }
}