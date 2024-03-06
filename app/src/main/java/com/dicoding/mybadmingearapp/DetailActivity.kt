package com.dicoding.mybadmingearapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_GEAR = "key_gear"
    }

    fun share(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        startActivity(Intent.createChooser(intent, "share with"))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataGear = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Gears>(DetailActivity.KEY_GEAR, Gears::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Gears>(DetailActivity.KEY_GEAR)
        }

        val detailTitle: TextView = findViewById(R.id.detail_title)
        val detailDesc: TextView = findViewById(R.id.detail_desc)
        val detailPict: ImageView = findViewById(R.id.detail_image)

        detailTitle.text = dataGear?.name
        detailDesc.text = dataGear?.description
        if (dataGear != null) {
            detailPict.setImageResource(dataGear.photo)
        }
    }
}