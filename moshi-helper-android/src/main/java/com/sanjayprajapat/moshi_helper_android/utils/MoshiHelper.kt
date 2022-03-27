package com.sanjayprajapat.moshi_helper_android.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


/**
 * @author Sanjay Prajapt
 * Date: 26-03-2022
 * */
class MoshiHelper(val moshi: Moshi?) {

    /**
     * To convert object to json
     * @param t  is object type
     * @return String json
     * */
    inline fun <reified T> convertToJsonByMoshi( t:T ): String? {
        val jsonAdapter = moshi?.adapter(T::class.java)
        try {
            return jsonAdapter?.toJson(t)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
        return ""
    }

    /**
     * To convert json to object
     * @param json
     * @return object
     * */
    inline fun <reified T> convertFromJsonByMoshi(json:String):T?{
        val jsonAdapter = moshi?.adapter(T::class.java)
        try {
            return jsonAdapter?.fromJson(json)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    /**
     * To convert Json To List
     * @param jsonStr as json
     * */
    inline fun <reified T> convertFromJsonToListByMoshi(json: String):List<T>{
        val type = Types.newParameterizedType(List::class.java, T::class.java)
        val jsonAdapter = moshi?.adapter<List<T>>(type)
        return  try {
            jsonAdapter?.fromJson(json)?: emptyList()
        }catch (e:Exception){
            e.printStackTrace()
            emptyList()
        }
    }

    /**
     * TO convert From Json to Map
     * */
    inline fun <reified T1, reified T2> convertFromJsonToMapByMoshi(json: String): Map<T1, T2> {
        val mapType = Types.newParameterizedType(Map::class.java, T1::class.java, T2::class.java)
        val jsonAdapter = moshi?.adapter<Map<T1, T2>>(mapType)
        return try {
            jsonAdapter?.fromJson(json) ?: emptyMap()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyMap()
        }
    }




}