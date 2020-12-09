package andrey.elin.notes.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import andrey.elin.notes.R
import andrey.elin.notes.model.Note
import andrey.elin.notes.presentation.NoteViewModel
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class NoteFragmentTest {

    private val mockViewModel: NoteViewModel = mockk(relaxed = true)

    @Before
    fun setup() {
        kotlin.runCatching { startKoin { } }

        loadKoinModules(
            module {
                viewModel { (_: Note?) ->
                    mockViewModel
                }
            }
        )
    }

    @After
    fun clean() {
        stopKoin()
    }

    @Test
    fun save_note_on_button_click() {
        launchFragmentInContainer<NoteFragment>(themeResId = R.style.Theme_AppCompat)

        onView(withId(R.id.button)).perform(click())

        verify { mockViewModel.saveNote() }
    }

}