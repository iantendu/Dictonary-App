package com.plcoding.dictionary.dictonary_feature.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.plcoding.dictionary.dictonary_feature.data.util.JsonParser
import com.plcoding.dictionary.dictonary_feature.domain.model.Meaning
@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningJson(json:String):List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toMeaningJson(meaning:List<Meaning>):String{
        return jsonParser.toJson(
            meaning,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        )?:"[]"
    }

}