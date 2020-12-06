package andrey.elin.notes.di

import andrey.elin.notes.data.NotesRepository
import andrey.elin.notes.data.NotesRepositoryImpl
import andrey.elin.notes.data.db.DatabaseProvider
import andrey.elin.notes.data.db.FireStoreDatabaseProvider
import andrey.elin.notes.model.Note
import andrey.elin.notes.presentation.NoteViewModel
import andrey.elin.notes.presentation.NotesViewModel
import andrey.elin.notes.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object DependencyGraph {

    private val repositoryModule by lazy {
        module {
            single { NotesRepositoryImpl(get()) } bind NotesRepository::class
            single { FireStoreDatabaseProvider() } bind DatabaseProvider::class
        }
    }

    private val viewModelModule by lazy {
        module {
            viewModel { NotesViewModel(get()) }
            viewModel { SplashViewModel(get()) }
            viewModel { (note: Note?) -> NoteViewModel(get(), note) }
        }
    }


    val modules: List<Module> = listOf(repositoryModule, viewModelModule)
}