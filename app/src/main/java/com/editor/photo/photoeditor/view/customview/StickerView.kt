package com.editor.photo.photoeditor.view.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log.d
import android.widget.ImageView
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.editor.photo.photoeditor.R


class StickerView(context: Context, attr: AttributeSet?, parentLayout: ViewGroup) :
    BaseEditView(context, attr, parentLayout) {

    private val imageView: ImageView = ImageView(context)

    init {
        imageView.apply {
            //setImageDrawable(context.getDrawable(android.R.drawable.btn_star_big_off))
            scaleType = ImageView.ScaleType.CENTER_CROP
            val params =
                LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            params.gravity = Gravity.CENTER
            layoutParams = params
        }

        fl_for_item.addView(imageView)

        val params = fl_for_item.layoutParams
        params.apply {
            width = imageView.layoutParams.width
            height = imageView.layoutParams.width

        }
    }


    fun setStickerImage(id: Int) {
        imageView.setImageDrawable(context.getDrawable(id))
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = Math.min(widthMeasureSpec, heightMeasureSpec)
        d("StickerView", "onMeasure   $widthMeasureSpec    $heightMeasureSpec")
    }
}