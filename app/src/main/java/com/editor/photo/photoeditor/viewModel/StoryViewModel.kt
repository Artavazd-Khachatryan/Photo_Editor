package com.editor.photo.photoeditor.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.editor.photo.photoeditor.animation.CubeInRotationTransformation
import com.editor.photo.photoeditor.data.TemplateData

class StoryViewModel : ViewModel() {

    val templateList = TemplateData.templateList
    val templateMap = TemplateData.templateMap
    val pageTransformer: ViewPager.PageTransformer = CubeInRotationTransformation()

    private val _templateListVisibility: MutableLiveData<Int> = MutableLiveData()
    val templateListVisibility: LiveData<Int> = _templateListVisibility

    private val _editFragmentVisibility: MutableLiveData<Int> = MutableLiveData()
    val editFragmentVisibility: LiveData<Int> = _editFragmentVisibility

    private val _stickerPagerFragmentVisibility: MutableLiveData<Int> = MutableLiveData()
    val stickerPagerFragmentVisibility: LiveData<Int> = _stickerPagerFragmentVisibility


    init {
        _templateListVisibility.value = View.GONE
        _editFragmentVisibility.value = View.GONE
        _stickerPagerFragmentVisibility.value = View.GONE
    }

    fun openTemplateListClick() {
        _templateListVisibility.value = View.VISIBLE
    }

    fun closeTemplateListClick() {
        _templateListVisibility.value = View.GONE
    }

    fun openEditFragment() {
        _editFragmentVisibility.value = View.VISIBLE
    }

    fun closeEditFragment() {
        _editFragmentVisibility.value = View.GONE
    }

    fun openStickerPagerFragment() {
        _stickerPagerFragmentVisibility.value = View.VISIBLE
    }

    fun closeStickerPagerFragment() {
        backStickerPagerFragment()
        closeEditFragment()
    }

    fun backStickerPagerFragment() {
        _stickerPagerFragmentVisibility.value = View.GONE
    }

    fun addEditText() {

    }

}