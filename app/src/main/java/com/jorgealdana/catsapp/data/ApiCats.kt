package com.jorgealdana.catsapp.data

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.result.Result
import com.jorgealdana.catsapp.BuildConfig
import com.jorgealdana.catsapp.models.Cat

class ApiCats {
    fun get(
        endpoint: String,
        params: List<Pair<String, Any?>>? = null,
        headers: Map<String, Any>,
        callback: (result: Result<String, Exception>) -> Unit
    ) {
        Fuel.get(
            BuildConfig.BASE_URL + endpoint,
            params
        ).header(headers).responseString() { _, response, result ->
            if (response.statusCode == 200) {
                callback(result)
            } else {
                callback(Result.error(Exception("HTTP Error ${response.statusCode}")))
            }
        }
    }
}