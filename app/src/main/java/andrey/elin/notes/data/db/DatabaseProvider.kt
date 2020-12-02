package andrey.elin.notes.data.db

import androidx.lifecycle.LiveData
import andrey.elin.notes.data.Note

interface DatabaseProvider {
    fun observeNotes(): LiveData<List<Note>>
    fun addOrReplaceNote(newNote: Note): LiveData<Result<Note>>
}