package com.example.customcanvasdrawing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


class CvDemo2(context: Context?, attrs: AttributeSet?): View(context,attrs) {
    //    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
//    val faceColor = Color.GREEN
//    val borderSize = 4.0f
//    var size = 320
//
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        drawFace(canvas)
//    }
//
//    fun drawFace(canvas: Canvas?){
//        paint.color = faceColor
//        paint.style = Paint.Style.FILL
//        val radius = size/2f
//        canvas?.drawCircle(size/2f, size/2f, radius , paint)
//    }
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val faceColor = Color.CYAN
    val borderSize = 4.0f
    var size = 320
    var borderColor = Color.MAGENTA
    val faceColorOuter = Color.YELLOW
    private val mouthPath = Path()

    override fun onDraw(canvas: Canvas?) {
        drawFace(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawFace(canvas: Canvas?) {
//        paint.color=faceColor
//        paint.style=Paint.Style.FILL
//        val radius=size/2f
//        canvas?.drawCircle((size+350)/2f,size+50/2f,radius,paint)
//        paint.color=borderColor
//        paint.style=Paint.Style.STROKE
//        paint.strokeWidth=borderSize+80
//        canvas?.drawCircle((size+350)/2f,size+50/2f,radius-borderSize,paint)
//        paint.color=faceColorOuter
//        paint.style=Paint.Style.STROKE
//        paint.strokeWidth=borderSize+80
//        canvas?.drawCircle((size+350)/2f,size+50/2f,radius+80,paint)

        paint.color = faceColor
        paint.style = Paint.Style.FILL
        val radius = size / 2f
        canvas?.drawCircle(size / 2f, size / 2f, radius, paint)

    }

    fun drawEyes(canvas: Canvas?) {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        val leftEye = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)
        canvas?.drawOval(leftEye, paint)
        val rightEye = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas?.drawOval(rightEye, paint)

    }

    fun drawMouth(canvas: Canvas?) {
        mouthPath.moveTo(size*0.22f, size*0.7f)
        mouthPath.quadTo(size*0.50f, size*0.80f, size * 0.78f, size*0.70f)
        mouthPath.quadTo(size*0.50f, size*0.90f, size* 0.22f, size * 0.70f)

        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas?.drawPath(mouthPath, paint)
    }
}