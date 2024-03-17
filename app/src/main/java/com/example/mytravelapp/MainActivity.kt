package com.example.mytravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.alpha

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    private var nameOfPlaces= arrayOf("tajmahal","girl","india","boy","building","beauty")

private lateinit var image:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val next = findViewById<Button>(R.id.btnNext)
        val previous = findViewById<Button>(R.id.btnPrrev)
        val place=findViewById<TextView>(R.id.txtName)

        //i want ot get the next image
        next.setOnClickListener {
            val currentImageId = resources.getIdentifier("img$currentImage", "id", packageName)//getting image id in integer format
            val nextImageId = resources.getIdentifier("img${(nameOfPlaces.size+currentImage + 1)%nameOfPlaces.size}", "id", packageName)

            if (nextImageId != 0) {
                image = findViewById(nextImageId)//converting into  image format
                image.alpha = 1f // Show next image
                currentImage += 1 // Update currentImage to the next one


                // Hide the previous image
                val previousImage = findViewById<ImageView>(currentImageId)
                previousImage.alpha = 0f
                place.text=nameOfPlaces[currentImage]
            } else {
                // Log a message or handle the case when there is no next image
                Log.d("NextImage", "No more images available.")
            }
        }


        //i want to get the previous image
        previous.setOnClickListener {
            val currentImageId = resources.getIdentifier("img$currentImage", "id", packageName)//getting image id in integer format
            val nextImageId = resources.getIdentifier("img${(currentImage - 1+nameOfPlaces.size)%nameOfPlaces.size}", "id", packageName)

            if (nextImageId != 0) {
                image = findViewById(nextImageId)//converting into  image format
                image.alpha = 1f // Show next image
                currentImage -= 1 // Update currentImage to the next one

                // Hide the previous image
                val previousImage = findViewById<ImageView>(currentImageId)

                previousImage.alpha = 0f//alpha 0 makdes image invisible
                place.text=nameOfPlaces[currentImage]

            } else {
                // Log a message or handle the case when there is no next image
                Log.d("NextImage", "No more images available.")
            }
        }


    }
}
