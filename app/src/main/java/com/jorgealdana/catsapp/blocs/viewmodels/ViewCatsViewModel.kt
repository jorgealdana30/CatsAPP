package com.jorgealdana.catsapp.blocs.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jorgealdana.catsapp.BuildConfig
import com.jorgealdana.catsapp.data.ApiCats
import com.jorgealdana.catsapp.models.Cat

class ViewCatsViewModel : ViewModel() {

    private val _cats = MutableLiveData<List<Cat>>()
    val cats: MutableLiveData<List<Cat>>
        get() = _cats

    fun fetchCats() {
        val api = ApiCats()
        api.get("breeds", listOf(Pair("x-api-key", BuildConfig.API_KEY)), mapOf()) { result ->
            result.fold({ data ->
                val cats = Gson().fromJson(data, Array<Cat>::class.java).toList()
                _cats.postValue(cats)
            }, { error ->
                println("Error: $error")
            })
        }
    }
}