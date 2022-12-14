package com.example.avengerschallenge.presentation.mainfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avengerschallenge.domain.AvengersRepository
import com.example.avengerschallenge.domain.models.MarvelDomain
import com.example.avengerschallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val avengersRepository: AvengersRepository)
    : ViewModel() {

    private val _characterList = MutableLiveData<List<MarvelDomain>?>()
    val characterList : LiveData<List<MarvelDomain>?>
    get() = _characterList
    private val _error = MutableLiveData<String>()
    val error : LiveData<String>
    get() = _error

    init {
        getCharacterList()
    }

    fun getCharacterList(){
        viewModelScope.launch (Dispatchers.IO){
            try {
                when(val result = avengersRepository.fetchAvengersComics()){
                    is Resource.Success -> {
                        _characterList.postValue(result.data)
                    }
                    is Resource.Failure -> _error.postValue(result.message?:"Error")
                }
            }catch (ex: Exception){
                Log.e("MainViewModel",ex.toString())
            }
        }
    }
}