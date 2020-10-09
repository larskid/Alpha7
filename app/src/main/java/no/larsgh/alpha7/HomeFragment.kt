package no.larsgh.alpha7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    var placeFields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.bgp_button).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment)
        }
        view.findViewById<Button>(R.id.search_button).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment)
        }
        val autocompleteFragment = childFragmentManager.findFragmentById(R.id.searchView) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(placeFields)
        autocompleteFragment.setTypeFilter(TypeFilter.ESTABLISHMENT)
        autocompleteFragment.setCountry("NO")
        autocompleteFragment.setOnPlaceSelectedListener(object: PlaceSelectionListener {
            override fun onPlaceSelected(p0: Place) {
                findNavController().navigate(R.id.action_homeFragment_to_resultFragment)
            }
            override fun onError(p0: Status) {
                Toast.makeText(activity, ""+p0.statusMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}