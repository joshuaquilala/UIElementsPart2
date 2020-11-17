package com.example.uielementspart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView

class AlbumsAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        val GridView = findViewById<GridView>(R.id.gridView) as GridView

        GridView.adapter = Images(applicationContext)

        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, AlbumDetails::class.java)
            var songsToBeDisplayed = arrayListOf<String>()
            var uri: String = ""
            if (position == 0) {
                uri = "@drawable/divide_cover"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.Bastille))
            } else if (position == 1) {
                uri = "@drawable/abbey_road_cover"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.Dax))
            } else {
                uri = "@drawable/scorpion_cover"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.Gloc_9))
            }
            intent.putStringArrayListExtra("songs", songsToBeDisplayed )
            intent.putExtra("imageUri",  uri)
            intent.putExtra("position", position)
            startActivity(intent)


        }



    }




}



