package andrey.elin.notes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import andrey.elin.notes.data.NotesRepositoryImpl

class NotesViewModel : ViewModel() {
    fun observeViewState(): LiveData<ViewState> = NotesRepositoryImpl.observeNotes()
        .map {
            if (it.isEmpty()) ViewState.EMPTY else ViewState.Value(it)
        }
}