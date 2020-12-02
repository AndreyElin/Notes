package andrey.elin.notes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import andrey.elin.notes.data.NotesRepositoryImpl
import andrey.elin.notes.data.notesRepository

class NotesViewModel : ViewModel() {
    fun observeViewState(): LiveData<ViewState> = notesRepository.observeNotes()
        .map {
            if (it.isEmpty()) ViewState.EMPTY else ViewState.Value(it)
        }
}