package com.plcoding.dictionary.dictonary_feature.data.remote

import androidx.room.Dao
import com.plcoding.dictionary.dictonary_feature.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

@Dao
interface DictonaryApi {
    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word:String
    ):List<WordInfoDto>

}