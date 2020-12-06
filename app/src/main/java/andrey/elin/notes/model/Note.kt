package andrey.elin.notes.model

import android.content.Context
import android.os.Parcelable
import androidx.core.content.ContextCompat
import andrey.elin.notes.R
import andrey.elin.notes.data.noteId
import kotlinx.android.parcel.Parcelize
import kotlin.random.Random

@Parcelize
data class Note(
    val id: Long = noteId,
    val title: String = "",
    val note: String = "",
    val color: Color = Random.nextEnum(),
) : Parcelable

inline fun <reified T : Enum<T>> Random.nextEnum(): T {
    return enumValues<T>().random(this)
}

enum class Color {
    WHITE,
    YELLOW,
    GREEN,
    BLUE,
    RED,
    VIOLET,
    PINK
}

fun Color.mapToColor(context: Context): Int {

    val id = when (this) {
        Color.WHITE -> R.color.color_white
        Color.YELLOW -> R.color.color_yellow
        Color.GREEN -> R.color.color_green
        Color.BLUE -> R.color.color_blue
        Color.RED -> R.color.color_red
        Color.VIOLET -> R.color.color_violet
        Color.PINK -> R.color.color_pink
    }

    return ContextCompat.getColor(context, id)
}