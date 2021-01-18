package com.nicolas.nnews.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nicolas.nnews.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        toolbar.title = "NNews"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Picasso.get().load(intent.getStringExtra("img")).into(imgViewDetails)
        txtDecriptionDetails.text = intent.getStringExtra("n")
        txtContentDescription.text = intent.getStringExtra("c")

    }
}