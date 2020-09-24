package io.github.loshine.nbnhhsh.ui.guess

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.loshine.nbnhhsh.data.repo.GuessRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class GuessViewModel @ViewModelInject constructor(private val guessRepository: GuessRepository) :
    ViewModel() {

    val data = MutableLiveData<List<String>>()
    val loading = MutableLiveData<Boolean>()

    fun guess(text: String) {
        viewModelScope.launch {
            guessRepository.guess(text)
                .map { list ->
                    list.asSequence()
                        .map { it.trans }
                        .filterNotNull()
                        .filter { it.isNotEmpty() }
                        .fold(mutableListOf<String>()) { l, s ->
                            l.apply { addAll(s) }
                        }
                        .toList()
                }
                .onStart { loading.value = true }
                .onEach { data.value = it }
                .catch { loading.value = false }
                .onCompletion { loading.value = false }
                .collect()
        }
    }
}