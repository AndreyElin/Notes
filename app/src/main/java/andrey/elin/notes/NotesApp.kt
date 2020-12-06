package andrey.elin.notes

import androidx.multidex.MultiDexApplication
import andrey.elin.notes.di.DependencyGraph
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.KoinContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class NotesApp: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NotesApp)
            modules(DependencyGraph.modules)
        }
    }
}