package no.larsgh.alpha7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.io.IOException
import android.util.Log
import androidx.constraintlayout.motion.widget.Debug.printStack
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.libraries.places.internal.e
import kotlinx.android.synthetic.main.activity_popfilm.*
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.Charset
import java.util.*
import kotlin.collections.ArrayList

class PopulereFilmer : AppCompatActivity(){

    var filmNavn: ArrayList<String> = ArrayList()
    var filmGenre: ArrayList<String> = ArrayList()
    var filmDesc: ArrayList<String> = ArrayList()
    var filmViews: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popfilm)

        title = "Favorit filmer"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(loadJSONFromAsset())
            val filmArray = obj.getJSONArray("filmer")
            for (i in 0 until filmArray.length()) {
                val filmDetalj = filmArray.getJSONObject(i)
                filmNavn.add(filmDetalj.getString("mov_title"))
                filmGenre.add(filmDetalj.getString("mov_genre"))
                filmDesc.add(filmDetalj.getString("mov_desc"))
                filmViews.add(filmDetalj.getString("views"))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val customAdapter = CustomAdapter(this@PopulereFilmer, filmNavn, filmGenre, filmDesc, filmViews)
    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("filmMockData.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}