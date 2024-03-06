package com.dicoding.mybadmingearapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvGears: RecyclerView
    private val list = ArrayList<Gears>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGears = findViewById(R.id.rv_gears)
        rvGears.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile_button -> {
                val intent = Intent(this, profileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListHeroes(): ArrayList<Gears> {
        val dataName = resources.getStringArray(R.array.gear_names)
        val dataDescription = resources.getStringArray(R.array.gear_description)
        val dataPhoto = resources.obtainTypedArray(R.array.gear_photo)
        val listHero = ArrayList<Gears>()
        for (i in dataName.indices) {
            val hero = Gears(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvGears.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListGearAdapter(list)
        rvGears.adapter = listHeroAdapter
    }
}