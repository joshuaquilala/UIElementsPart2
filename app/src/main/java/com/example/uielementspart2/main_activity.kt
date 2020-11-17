package com.example.uielementspart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class main_activity : AppCompatActivity() {

    val queuedSongs = ArrayList<String>() //Array where all the songs queued will be stored and will be passed to the Queue activity
    val songsArray = arrayOf("Quarter Past Midnight", "Bad Decisions", "The Waves", "Million Pieces", "Doom Days",
        "Joker", "Dear God", "My Last Words", "Godzilla", "Unforgivable",
        "Halik", "Upuan", "Martilyo", "Dungaw", "Ayoko na")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        val songsListView = findViewById<ListView>(R.id.songsListView)
        songsListView.adapter = adapter

        registerForContextMenu(songsListView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.add_song_to_queue -> {
                queuedSongs.add(songsArray[menuInfo.position])
                true
            }
            else -> {
                return super.onContextItemSelected(item)
            }

        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.go_to_songs -> {
                startActivity(Intent(this, main_activity::class.java))
                true
            }
            R.id.go_to_album -> {
                startActivity(Intent(this, AlbumsAct::class.java))
                true
            }
            R.id.go_to_queue -> {
                val intent = Intent(this, QueueAct::class.java)
                intent.putStringArrayListExtra("songs", queuedSongs)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)

        }


    }
}