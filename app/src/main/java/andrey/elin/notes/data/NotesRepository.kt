package andrey.elin.notes.data

import andrey.elin.notes.model.User
import androidx.lifecycle.LiveData

interface NotesRepository {
    fun getCurrentUser(): User?
    fun observeNotes(): LiveData<List<Note>>
    fun addOrReplaceNote(newNote: Note): LiveData<Result<Note>>
}