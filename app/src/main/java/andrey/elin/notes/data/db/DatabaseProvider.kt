package andrey.elin.notes.data.db

import androidx.lifecycle.LiveData
import andrey.elin.notes.data.Note
import andrey.elin.notes.model.User

interface DatabaseProvider {
    fun getCurrentUser(): User?
    fun observeNotes(): LiveData<List<Note>>
    fun addOrReplaceNote(newNote: Note): LiveData<Result<Note>>
}