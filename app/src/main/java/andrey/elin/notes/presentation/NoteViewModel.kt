package andrey.elin.notes.presentation

import androidx.lifecycle.*
import andrey.elin.notes.data.Note
import andrey.elin.notes.data.NotesRepositoryImpl
import andrey.elin.notes.data.notesRepository

class NoteViewModel(var note: Note?) : ViewModel() {
    private val showErrorLiveData = MutableLiveData<Boolean>()

    private val lifecycleOwner: LifecycleOwner = LifecycleOwner { viewModelLifecycle }
    private val viewModelLifecycle = LifecycleRegistry(lifecycleOwner).also {
        it.currentState = Lifecycle.State.RESUMED
    }

    fun updateNote(text: String) {
        note = (note ?: generateNote()).copy(note = text)
    }

    fun updateTitle(text: String) {
        note = (note ?: generateNote()).copy(title = text)
    }

    fun saveNote() {
        note?.let { note ->
            notesRepository.addOrReplaceNote(note).observe(lifecycleOwner) {
                it.onFailure {
                    showErrorLiveData.value = true
                }
            }
        }
    }

    fun showError(): LiveData<Boolean> = showErrorLiveData

    override fun onCleared() {
        super.onCleared()
        viewModelLifecycle.currentState = Lifecycle.State.DESTROYED
    }

    private fun generateNote(): Note {
        return Note()
    }
}
