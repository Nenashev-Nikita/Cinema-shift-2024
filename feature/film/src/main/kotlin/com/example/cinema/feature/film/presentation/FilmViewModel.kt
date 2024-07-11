package com.example.cinema.feature.film.presentation

import com.example.cinema.component.arch.BaseViewModel
import com.example.cinema.feature.film.domain.usecase.GetFilmUseCase
import com.example.cinema.feature.film.presentation.converter.FilmUiConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class FilmViewModel @Inject constructor(
	private val getFilmUseCase: GetFilmUseCase,
	private val filmUiConverter: FilmUiConverter,
): BaseViewModel() {

	private val _state = MutableStateFlow<FilmState>(FilmState.Initial)
	val state: StateFlow<FilmState> = _state

	fun loadFilm(filmId: Long) {
		launch {
			_state.value = FilmState.Loading

			try {
				val film = getFilmUseCase(filmId)
				_state.value = FilmState.Content(filmUiConverter(film))
			} catch (ce: CancellationException) {
				throw ce
			} catch (ex: Exception) {
				_state.value = FilmState.Failure(ex.localizedMessage.orEmpty())
			}
		}
	}
}