package com.example.canvascustomdrawing

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatTextView


class TextViewCustom : AppCompatTextView {
    private var title: String? = null
    private var color = false
    private var bg:Int = Color.BLACK
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val tarry: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustom)
        try {
            title = tarry.getString(R.styleable.TextViewCustom_settitle)
            if (title == null)
                setText("Custom Message")
            else
                setText(title)

            color = tarry.getBoolean(R.styleable.TextViewCustom_setColor, false)
            if (color)
                setTextColor(Color.MAGENTA)
            bg = tarry.getColor(R.styleable.TextViewCustom_setbg, Color.BLUE)
            if (bg != null){
                setBackgroundColor(bg)
            }
            else{
                setBackgroundColor(Color.WHITE)
            }
        }
        finally {
            tarry.recycle()
        }
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  { }
}