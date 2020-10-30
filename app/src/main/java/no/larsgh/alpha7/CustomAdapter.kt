package no.larsgh.alpha7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class CustomAdapter(private var context: Context, private
var filmNavn: ArrayList<String>,private
var filmGenre: ArrayList<String>, private
var filmDesc: ArrayList<String>, private
var filmViews: ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
            return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        holder.mov_title.text = filmNavn[position]
        holder.mov_genre.text = filmGenre[position]
        holder.mov_desc.text = filmDesc[position]
        holder.views.text = filmViews[position]
    }


    override fun getItemCount(): Int {
        return filmNavn.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mov_title: TextView = itemView.findViewById<View>(R.id.movtitle) as TextView
        var mov_genre: TextView = itemView.findViewById<View>(R.id.movgenre) as TextView
        var mov_desc: TextView = itemView.findViewById<View>(R.id.movdesc) as TextView
        var views: TextView = itemView.findViewById<View>(R.id.movviews) as TextView
    }
}