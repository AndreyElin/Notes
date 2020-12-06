package andrey.elin.notes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import andrey.elin.notes.R
import android.content.Context
import android.content.Intent
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun navigateTo(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, fragment)
            addToBackStack("notes")
        }
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}