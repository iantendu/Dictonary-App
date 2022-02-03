package com.plcoding.dictionary.dictonary_feature.data.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.dictonary_feature.data.local.WordInfoDao
import com.plcoding.dictionary.dictonary_feature.data.remote.DictonaryApi
import com.plcoding.dictionary.dictonary_feature.domain.model.WordInfo
import com.plcoding.dictionary.dictonary_feature.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictonaryApi,
    private val dao: WordInfoDao

) :WordInfoRepository{
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading())

        val wordInfos=dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos=api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })


        }catch (e:HttpException){

        }catch (e:IOException){

        }

    }
}