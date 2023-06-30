package com.example.activity_shared_preference

import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream
import java.util.*

class Image_fetch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var iv = findViewById<ImageView>(R.id.iv)
        var ivv = findViewById<ImageView>(R.id.ivv)
        var save = findViewById<Button>(R.id.save)
        var show = findViewById<Button>(R.id.show)
        save.setOnClickListener{
            saveImage(iv,this)
        }
    }
    fun saveImage(imageView: ImageView,context: Context){
        val sharedPref = context.getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        val baos = ByteArrayOutputStream()
        val bitmap = imageView.drawable.toBitmap()
        bitmap.compress(Bitmap.CompressFormat.PNG,100,baos)
        val encodeImage = Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT)
        with(sharedPref.edit()){
            putString("encodedImage",encodeImage)
            apply()
        }
    }
}