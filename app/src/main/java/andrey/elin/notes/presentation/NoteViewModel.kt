package andrey.elin.notes.presentation

import androidx.lifecycle.ViewModel
import andrey.elin.notes.data.Note
import andrey.elin.notes.data.NotesRepositoryImpl

class NoteViewModel(var note: Note?) : ViewModel() {

    fun updateNote(text: String) {
        note = (note ?: generateNote()).copy(note = text)
    }

    fun updateTitle(text: String) {
        note = (note ?: generateNote()).copy(title = text)
    }

    override fun onCleared() {
        super.onCleared()

        note?.let {
            NotesRepositoryImpl.addOrReplaceNote(it)
        }
    }

    private fun generateNote(): Note {
        return Note()
    }
}
