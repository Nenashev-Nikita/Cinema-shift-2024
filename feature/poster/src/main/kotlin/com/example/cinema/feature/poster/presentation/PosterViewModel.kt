package com.example.cinema.feature.poster.presentation

import com.example.cinema.component.arch.BaseViewModel
import com.example.cinema.feature.poster.domain.usecase.GetFilmsUseCase
import com.example.cinema.feature.poster.presentation.converter.FilmsUiConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class PosterViewModel @Inject constructor(
	private val getFilmsUseCase: GetFilmsUseCase,
	private val filmsUiConverter: FilmsUiConverter,
) : BaseViewModel() {

	private val _state = MutableStateFlow<PosterState>(PosterState.Initial)
	val state: StateFlow<PosterState> = _state

	fun loadPoster() {
		launch {
			_state.value = PosterState.Loading

			try {
				val films = getFilmsUseCase()
				_state.value = PosterState.Content(filmsUiConverter(films))
			} catch (ce: CancellationException) {
				throw ce
			} catch (ex: Exception) {
				_state.value = PosterState.Failure(ex.localizedMessage.orEmpty())
			}
		}
	}
}