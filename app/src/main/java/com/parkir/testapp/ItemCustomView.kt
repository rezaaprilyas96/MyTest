package com.parkir.testapp

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.item_view_custom.view.*
import kotlin.concurrent.thread

class ItemCustomView (context: Context, attributeSet: AttributeSet): LinearLayout(context, attributeSet) {
    init {
        inflate(context,R.layout.item_view_custom, this)

        val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.ItemCustomView)

        val jumlahRating:Float = (attributes.getInt(R.styleable.ItemCustomView_rate,0)).toFloat()
        val statusVerified:Boolean = attributes.getBoolean(R.styleable.ItemCustomView_verified, false)

        img_sampul.setImageDrawable(attributes.getDrawable(R.styleable.ItemCustomView_sampul))
        tv_tittle.text = attributes.getString(R.styleable.ItemCustomView_tittle)
        tv_description.text = attributes.getString(R.styleable.ItemCustomView_description)
        rb_cutom.setRating(jumlahRating)

        if(statusVerified){
            img_verified.setImageResource(R.drawable.ic_baseline_verified_user_24)
        }

        attributes.recycle()
    }
}
