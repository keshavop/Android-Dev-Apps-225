package com.example.canvascustomdrawing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CvDemo2(context: Context?, attrs: AttributeSet?): View(context,attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val faceColor = Color.CYAN
    val borderSize = 4.0f
    var size = 320

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFace(canvas)
    }

    fun drawFace(canvas: Canvas?){
        paint.color = faceColor
        paint.style = Paint.Style.FILL
        val radius = size/2f

    }
}