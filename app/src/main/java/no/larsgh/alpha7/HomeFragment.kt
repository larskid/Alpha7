package no.larsgh.alpha7

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    var placeFields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS, Place.Field.TYPES)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // Connect button(s) to the propper pages
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button to "Bruk gjelende plassering
        view.findViewById<Button>(R.id.bgp_button).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment)
        }

        //Button to "Vis populære filmer"
        view.findViewById<Button>(R.id.vpf_button).setOnClickListener {
            var intent1 = Intent(activity, PopulereFilmer::class.java)
            activity?.startActivity(intent1)
        }


        val autocompleteFragment = childFragmentManager.findFragmentById(R.id.googleAutocomplete) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(placeFields)
        autocompleteFragment.setCountry("NO")
        autocompleteFragment.view?.setBackgroundColor(Color.WHITE)
        autocompleteFragment.setOnPlaceSelectedListener(object: PlaceSelectionListener {
            override fun onPlaceSelected(p0: Place) {
                var intent2 = Intent(activity, TabbedAct::class.java)
                startActivity(intent2)
            }
            override fun onError(p0: Status) {
                Toast.makeText(activity, ""+p0.statusMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}