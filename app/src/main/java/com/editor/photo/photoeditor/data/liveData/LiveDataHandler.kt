package com.editor.photo.photoeditor.data.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.editor.photo.photoeditor.data.models.CommandModel


object LiveDataHandler {

    private val _editFragmentLiveData: MutableLiveData<CommandModel> = MutableLiveData()
    val editFragmentLiveData: LiveData<CommandModel> = _editFragmentLiveData


    fun setCommand(command: CommandModel) {
        _editFragmentLiveData.value = command
    }









}