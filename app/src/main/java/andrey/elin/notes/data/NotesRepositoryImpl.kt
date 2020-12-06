package andrey.elin.notes.data

import andrey.elin.notes.data.db.DatabaseProvider
import andrey.elin.notes.model.Note
import androidx.lifecycle.LiveData
import kotlin.random.Random

private val idRandom = Random(0)
val noteId: Long
    get() = idRandom.nextLong()

class NotesRepositoryImpl(private val provider: DatabaseProvider) : NotesRepository {

    override fun getCurrentUser() = provider.getCurrentUser()

    override fun observeNotes(): LiveData<List<Note>> {
        return provider.observeNotes()
    }

    override fun addOrReplaceNote(newNote: Note): LiveData<Result<Note>> {
        return provider.addOrReplaceNote(newNote)
    }
}

