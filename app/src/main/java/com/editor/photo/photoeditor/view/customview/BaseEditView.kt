package com.editor.photo.photoeditor.view.customview

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.util.Log.d
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.util.MonitorsTheCoordinates
import com.editor.photo.photoeditor.util.ViewStateChangeListener
import kotlin.properties.Delegates


abstract class BaseEditView(context: Context, attrs: AttributeSet?, val parentLayout: ViewGroup) :
    FrameLayout(context, attrs), View.OnClickListener, View.OnTouchListener,
    ViewStateChangeListener {

    var active: Boolean by Delegates.observable(true) { _, oldValue, newValue ->
        if (newValue) {
            frameVisibility(View.VISIBLE)
        } else {
            frameVisibility(View.INVISIBLE)
        }
    }

    lateinit var mainView: View
    lateinit var vLeft: View
    lateinit var vTop: View
    lateinit var vRight: View
    lateinit var vBottom: View
    lateinit var ivDelete: ImageView
    lateinit var fl_for_item: FrameLayout


    private val monitorsTheCoordinates = MonitorsTheCoordinates(context, this)


    init {
        inflateAndFindView()
    }


    private fun inflateAndFindView() {
        mainView = inflate(context, R.layout.base_frame_view, this)
        mainView.setOnTouchListener(this)

        fl_for_item = mainView.findViewById(R.id.fl_for_item)
        ivDelete = mainView.findViewById(R.id.btnDelete)
        ivDelete.setOnClickListener { parentLayout.removeView(this) }


        vLeft = mainView.findViewById(R.id.v_line_left)
        vTop = mainView.findViewById(R.id.v_line_top)
        vRight = mainView.findViewById(R.id.v_line_right)
        vBottom = mainView.findViewById(R.id.v_line_bottom)

        frameVisibility(View.INVISIBLE)

        setOnClickListener { onClick(it) }

    }

    fun isActive(): Boolean = active

    private fun frameVisibility(visibility: Int) {
        ivDelete.visibility = visibility
        vLeft.visibility = visibility
        vTop.visibility = visibility
        vRight.visibility = visibility
        vBottom.visibility = visibility
    }

    override fun onClick(v: View?) {
        active = true
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        monitorsTheCoordinates.onTouchEvent(this, event)
        return true
    }

    override fun onPositionChanged(x: Float, y: Float) {
        this.x += x
        this.y += y
    }

    override fun onAngleChanged(angel: Float) {
        fl_for_item.rotation += angel
    }

    override fun onScaleChanged(scale: Float) {
        //mainView.setScaleX(scale)
        //mainView.setScaleY(scale)
    }
}