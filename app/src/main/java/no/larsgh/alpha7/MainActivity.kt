package no.larsgh.alpha7

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient

class MainActivity : AppCompatActivity() {

    lateinit var googlemapsClient: PlacesClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        initPlaces()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.action_bks).isVisible = false
        menu.findItem(R.id.action_fkpk).isVisible = false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings ->  true
            R.id.action_tema -> true
            R.id.action_bks -> true
            R.id.action_fkpk -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initPlaces() {
        Places.initialize(this, getString(R.string.googlemaps_api))
        googlemapsClient = Places.createClient(this)
    }
}