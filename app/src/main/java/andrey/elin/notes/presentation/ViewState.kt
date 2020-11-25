package andrey.elin.notes.presentation

import andrey.elin.notes.data.Note

sealed class ViewState {
    data class Value(val notes: List<Note>) : ViewState()
    object EMPTY : ViewState()
}