package com.editor.photo.photoeditor.view.customview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.EditText
import com.editor.photo.photoeditor.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.properties.Delegates

class CustomEditTextView(context: Context, attr: AttributeSet?, parentLayout: ViewGroup) :
    BaseEditView(context, attr, parentLayout), GestureDetector.OnDoubleTapListener {

    private val editText: EditText = EditText(context)
    var isEditTextFocus: Boolean by Delegates.observable(false) { _, _, newValue ->
        editText.isFocusable = newValue
    }

    init {
        editText.setText(context.getString(R.string.enter_your_text))
        editText.setOnTouchListener(this)
        editText.isFocusable = false
        editText.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
        editText.setOnClickListener { onClick(it) }
        fl_for_item.addView(editText)

        val params = fl_for_item.layoutParams
        params.apply {
            width = editText.layoutParams.width
            height = editText.layoutParams.width
        }

    }


    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        isEditTextFocus = true
    }
}