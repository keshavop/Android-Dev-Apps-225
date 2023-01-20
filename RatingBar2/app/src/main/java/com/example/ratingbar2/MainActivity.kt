package com.example.ratingbar2

import android.widget.Button
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val qualityBar = findViewById<RatingBar>(R.id.qualityBar)
        val quantityBar = findViewById<RatingBar>(R.id.quantityBar)
        val orderingBar = findViewById<RatingBar>(R.id.orderingBar)
        val deliveryBar = findViewById<RatingBar>(R.id.deliveryBar)
        val finalRating = findViewById<RatingBar>(R.id.finalRatingBar)

        submitBtn.setOnClickListener(){
            val totalStars = (quantityBar.rating + qualityBar.rating + deliveryBar.rating + orderingBar.rating)/4
            Toast.makeText(this@MainActivity,"""$totalStars""", Toast.LENGTH_LONG).show()

            val res = totalStars
            finalRating.rating = res

        }

        var ts=0
        qualityBar.onRatingBarChangeListener = RatingBar.onRatingBarChangeListener{
                ratingBar,rating,fromUser ->
            val qualityRating = rating
        }

        quantityBar.onRatingBarChangeListener = RatingBar.onRatingBarChangeListener{
                ratingBar,rating,fromUser ->
            val quailtyRating = rating
        }
        orderingBar.onRatingBarChangeListener = RatingBar.onRatingBarChange{
            ratingBar,rating,fromUser ->
            val orderRating = rating
        }
        deliveryBar.onRatingBarChangeListener = RatingBar.onRatingBarChange{
                ratingBar,rating,fromUser ->
            val deliveryRating = rating
        }

        val totalChangeRating = (qualityRating + quantityRating + deliveryRating + deliveryRating)/4

        finalRating.onRatingBarChangeListener = RatingBar.onRatingBarChange{
                ratingBar,rating,fromUser ->
            rating = totalChangeRating
        }
    }
}