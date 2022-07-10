package com.editor.photo.photoeditor.util

import android.content.Context
import android.os.Handler
import android.util.Log.d
import android.view.MotionEvent
import android.view.MotionEvent.*
import android.view.ScaleGestureDetector
import android.view.View
import com.editor.photo.photoeditor.data.constants.*
import com.editor.photo.photoeditor.data.models.Coordinate
import java.lang.Math.toDegrees
import kotlin.math.abs
import kotlin.math.asin
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.properties.Delegates


class MonitorsTheCoordinates(
    val context: Context,
    var viewStateChangeListener: ViewStateChangeListener
) {

    private val scaleGestureDetector = ScaleGestureDetector(context, ScaleListener())

    private val positionHandler: Handler = Handler()
    private val positionHandlerChangeTime = 7L

    private val rotateHandler: Handler = Handler()
    private val rotateHandlerChangeTime = 7L
    private var ROTATE_DIRECTION = EMPTY_DIRECTION

    private val zoomHandler: Handler = Handler()
    private val zoomHandlerChangeTime = 10L


    var centerCoordinate: Coordinate = Coordinate(-1f, -1f)
    var lastFinger1: Coordinate = Coordinate(-1f, -1f)
    var lastFinger2: Coordinate = Coordinate(-1f, -1f)


    private var TOUCH_STATE = NO_FINGER
    private var fingerCount: Int by Delegates.observable(NO_FINGER) { _, oldValue, newValue ->
        if (oldValue != newValue) {
            when (newValue) {
                0 -> TOUCH_STATE = NO_FINGER
                1 -> {
                    TOUCH_STATE = ONE_FINGER
                    resetPosition()
                }
                2 -> {
                    TOUCH_STATE = TWO_FINGER
                    resetAngel()
                }
            }

        }

    }

    private fun resetAngel() {
        angle = null
    }

    private fun resetPosition() {
        position = null
    }

    private var position: Coordinate? by Delegates.observable<Coordinate?>(null) { _, oldValue, newValue ->
        if (oldValue != null && newValue != null) {
            if (isFingerPositionChanged(oldValue, newValue)) {
                val position = calculateEventsPosition(oldValue, newValue)
                viewStateChangeListener.onPositionChanged(
                    position.coordinateX,
                    position.coordinateY
                )
            }

        }
    }

    private var angle: Float? by Delegates.observable<Float?>(null) { _, oldValue, newValue ->
        if (oldValue != null && newValue != null) {
            var angle = newValue - oldValue

            if (angle >= 0)
                angle += 0.3f
            else
                angle -= 0.3f

            if (abs(angle) >= 1f) {
                viewStateChangeListener.onAngleChanged(angle * ROTATE_DIRECTION)
            }

        }
    }

    private var scale: Float by Delegates.observable(1f) { property, oldValue, newValue ->
        d(
            "scale",
            "---------------------$oldValue-----$newValue--------${newValue - oldValue}-------------------"
        )
        viewStateChangeListener.onScaleChanged(newValue)
    }

    fun onTouchEvent(view: View, event: MotionEvent?) {
        fingerCount = event!!.pointerCount

        centerCoordinate.coordinateX = (view.width / 2).toFloat()
        centerCoordinate.coordinateY = (view.height / 2).toFloat()

        onPositionChangeTouch(event)
        onRotateTouch(event)
        onZoomTouch(event)

    }

    private fun onPositionChangeTouch(event: MotionEvent) {
        positionHandler.postDelayed({
            val action = event.action and ACTION_MASK
            if (TOUCH_STATE == ONE_FINGER) {
                when (action) {
                    ACTION_DOWN -> {
                        position = Coordinate(event.rawX, event.rawY)
                    }

                    ACTION_MOVE -> {
                        position = Coordinate(event.rawX, event.rawY)
                    }

                    ACTION_UP -> {
                        resetPosition()
                        fingerCount = 0
                        TOUCH_STATE = NO_FINGER
                    }
                }
            }
            positionHandler.removeCallbacksAndMessages(null)
        }, positionHandlerChangeTime)

    }

    private fun onRotateTouch(event: MotionEvent) {
        rotateHandler.postDelayed({
            val action = event.action and ACTION_MASK
            if (TOUCH_STATE == TWO_FINGER) {
                when (action) {
                    ACTION_POINTER_DOWN -> {
                        lastFinger1 = Coordinate(event.getX(0), event.getY(0))
                        lastFinger2 = Coordinate(event.getX(1), event.getY(1))
                        angle = calculateLineAngleForCenter(lastFinger1, lastFinger2)
                    }

                    ACTION_MOVE -> {
                        val finger1 = Coordinate(event.getX(0), event.getY(0))
                        val finger2 = Coordinate(event.getX(1), event.getY(1))
                        calculateRotateDirection(finger1, finger2)
                        if (isFingerPositionChanged(
                                lastFinger1,
                                finger1
                            ) || isFingerPositionChanged(lastFinger2, finger2)
                        ) {
                            angle = calculateLineAngleForCenter(finger1, finger2)
                        }
                    }


                    ACTION_POINTER_UP -> {
                        if (fingerCount - 1 > 2) {
                            fingerCount = 1
                            TOUCH_STATE = NO_FINGER
                            lastFinger1 = Coordinate(-1f, -1f)
                            lastFinger2 = Coordinate(-1f, -1f)
                        }


                    }
                }
            }
            rotateHandler.removeCallbacksAndMessages(null)

        }, rotateHandlerChangeTime)

    }

    private fun calculateRotateDirection(finger1: Coordinate, finger2: Coordinate) {
        ROTATE_DIRECTION = if (finger1.coordinateY > finger2.coordinateY) {
            LEFT_DIRECTION
        } else {
            RIGHT_DIRECTION
        }
    }

    private fun isFingerPositionChanged(
        lastPosition: Coordinate,
        curentPosition: Coordinate
    ): Boolean {
        val difference = calculateDistance(lastPosition, curentPosition)
        if (difference < 2) {
            return false
        }
        return true
    }

    private fun calculateEventsPosition(oldValue: Coordinate, newValue: Coordinate): Coordinate {
        val differenceX = newValue.coordinateX - oldValue.coordinateX
        val differenceY = newValue.coordinateY - oldValue.coordinateY
        return Coordinate(differenceX, differenceY)
    }

    private fun calculateDistance(coordinate1: Coordinate, coordinate2: Coordinate): Float {
        val difX = ((coordinate1.coordinateX - coordinate2.coordinateX).toDouble()).pow(2.0)
        val difY = ((coordinate1.coordinateY - coordinate2.coordinateY).toDouble()).pow(2.0)
        return sqrt(difX + difY).toFloat()
    }

    private fun calculateRotateAngel(finger1: Coordinate, finger2: Coordinate): Float {
        val dif = calculateDistance(finger1, finger2)
        val difY = abs(finger1.coordinateY - finger2.coordinateY)
        val sin = toDegrees(asin(difY / dif).toDouble())

        return sin.toFloat()
    }

    private fun calculateLineAngleForCenter(finger1: Coordinate, finger2: Coordinate): Float {

        val mainFinger: Coordinate = finger1

        val delta_x = mainFinger.coordinateX - centerCoordinate.coordinateX
        val delta_y = mainFinger.coordinateY - centerCoordinate.coordinateY

        finger1.coordinateX -= delta_x
        finger1.coordinateY -= delta_y

        finger2.coordinateX -= delta_x
        finger2.coordinateY -= delta_y


        var angle = calculateRotateAngel(finger1, finger2)

        if (finger2.coordinateX > centerCoordinate.coordinateX && finger2.coordinateY > centerCoordinate.coordinateY) {
            angle = -angle
        } else if (finger2.coordinateX < centerCoordinate.coordinateX && finger2.coordinateY > centerCoordinate.coordinateY) {
            angle = 0 - (180 - angle)
        } else if (finger2.coordinateX < centerCoordinate.coordinateX && finger2.coordinateY < centerCoordinate.coordinateY) {
            angle = 0 - (180 - angle)

        } else if (finger2.coordinateX > centerCoordinate.coordinateX && finger2.coordinateY < centerCoordinate.coordinateY) {
            angle = 360 - angle
        }

        return angle
    }

    private fun onZoomTouch(event: MotionEvent?) {
        zoomHandler.postDelayed({
            scaleGestureDetector.onTouchEvent(event)
            zoomHandler.removeCallbacksAndMessages(null)
        }, zoomHandlerChangeTime)

    }


    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        private var scaleFactor = 1.0f

        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = 0.1f.coerceAtLeast(scaleFactor.coerceAtMost(5.0f))
            scale = scaleFactor
            return true
        }
    }
}