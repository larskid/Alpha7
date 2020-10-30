package no.larsgh.alpha7

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_tema.*
import android.graphics.Color
import android.widget.TextView
import com.google.android.libraries.places.internal.hl
import com.google.android.libraries.places.internal.i
import kotlinx.android.synthetic.main.fragment_home.*


class TemaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tema)
        supportFragmentManager
            .beginTransaction()
            //.replace(R.id.action_settings, SettingsFragment())
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Koden for å endre backgrunsfargen, har feil
        //val hl = findViewById<TextView>(R.id.homeLayout)
        //switch_1.setOnCheckedChangeListener { buttonView, isChecked ->
        //    if (isChecked) {
        //        hl.setBackgroundColor(getColor(R.color.darkColor))
        //    }
        //    else {
        //        hl.setBackgroundColor(getColor(R.color.screenBackground))
        //    }
        //}
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}