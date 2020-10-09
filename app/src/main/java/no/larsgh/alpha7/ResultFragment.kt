package no.larsgh.alpha7

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultFragment : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_result)

        val values = arrayListOf("Kino one", "Kino two", "Kino three", "Kino Four")

        val mListView = findViewById<ListView>(R.id.resultItem)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        mListView.adapter = adapter

        mListView.setOnItemClickListener { parent, view, position, id ->
            for ( position in 0..position) {
                Toast.makeText(this@ResultFragment, "Kino " + (position+1) + " " + "clicked...", Toast.LENGTH_SHORT).show()
                //view.findViewById<ListView>(R.id.position).setOnClickListener {
                //    view.findNavController().navigate(R.id.action_resultFragment_to_tabsActivity)
                //}
            }
        }
    }

}