package com.example.uielementspart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import com.example.uielementspart2.Images
import uielementspart2.example.uielementspart2.AlbumDetails
import com.example.uielementspart2.R

var albumSongs = ArrayList<String>()
var albumURI = String

class AlbumsAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        val GridView = findViewById<GridView>(R.id.gridView) as GridView

        GridView.adapter = Images(applicationContext)

        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, AlbumDetails::class.java)
            var uri: String
            if (position == 0) {
                uri = "@drawable/bastille_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Bastille))
            } else if (position == 1) {
                uri = "@drawable/dax_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Dax))
            } else {
                uri = "@drawable/gloc9_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Gloc_9))
            }
            intent.putExtra("imageUri",  uri)
            startActivity(intent)


        }

    }


}



