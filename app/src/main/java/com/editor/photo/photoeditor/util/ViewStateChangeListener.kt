package com.editor.photo.photoeditor.util

interface ViewStateChangeListener {

    fun onPositionChanged(x: Float, y: Float)

    fun onAngleChanged(angel: Float)

    fun onScaleChanged(scale: Float)

}