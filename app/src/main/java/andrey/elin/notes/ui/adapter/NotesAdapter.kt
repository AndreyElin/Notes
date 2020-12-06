package andrey.elin.notes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import andrey.elin.notes.databinding.ItemNoteBinding
import andrey.elin.notes.model.Note
import andrey.elin.notes.model.mapToColor

val DIFF_UTIL: DiffUtil.ItemCallback<Note> = object : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return true
    }
}

class NotesAdapter(val noteHandler: (Note) -> Unit) :
    ListAdapter<Note, NotesAdapter.NoteViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NoteViewHolder(
        parent: ViewGroup,
        private val binding: ItemNoteBinding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {
        private lateinit var currentNote: Note

        private val clickListener: View.OnClickListener = View.OnClickListener {
            noteHandler(currentNote)
        }

        fun bind(item: Note) {
            currentNote = item
            with(binding) {
                title.text = item.title
                body.text = item.note
                root.setBackgroundColor(item.color.mapToColor(binding.root.context))
                root.setOnClickListener(clickListener)
            }
        }
    }
}