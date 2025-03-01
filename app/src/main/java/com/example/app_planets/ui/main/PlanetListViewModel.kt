package com.example.app_planets.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_planets.data.PlanetsRepository
import com.example.app_planets.data.api.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetListViewModel @Inject constructor(private val repository: PlanetsRepository) :
    ViewModel() {

    private val state = MutableLiveData<State>()
    val viewState : LiveData<State>
        get() = state

    fun loadData() {
        viewModelScope.launch {
            state.value = State.Loading
            val result = repository.getPlanetList()
            when(result){
                is ApiResult.Error -> {
                    state.value = State.Error
                }
                is ApiResult.Success -> {
                    state.value = State.Content(result.data)

                }
            }
        }
    }
}

sealed class State {
    data class Content(val list: List<PlanetData>) : State()
    object Loading : State()

    object Error : State()
}