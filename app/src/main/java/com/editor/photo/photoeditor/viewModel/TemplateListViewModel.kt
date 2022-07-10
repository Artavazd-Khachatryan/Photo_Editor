package com.editor.photo.photoeditor.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.editor.photo.photoeditor.data.ChooseTemplateListData
import com.editor.photo.photoeditor.data.constants.CLOSE_TEMPLATE_FRAGMENT_COMMAND
import com.editor.photo.photoeditor.data.liveData.LiveDataHandler
import com.editor.photo.photoeditor.data.models.CommandModel
import com.editor.photo.photoeditor.datawrap_content.ChooseTemplateTabListData
import com.editor.photo.photoeditor.view.adapter.ChooseTemplateListAdapter
import com.editor.photo.photoeditor.view.adapter.ChooseTemplateTabListAdapter

class TemplateListViewModel(application: Application) : AndroidViewModel(application) {

    var tabTitleList = ChooseTemplateTabListData.titleList

    val chooseTemplateTabListAdapter = ChooseTemplateTabListAdapter(tabTitleList)

    var chooseTemplateList = ChooseTemplateListData.chooseTemplateList

    val chooseTemplateListAdapter = ChooseTemplateListAdapter(chooseTemplateList)

    val layoutManager =
        LinearLayoutManager(application.applicationContext, LinearLayoutManager.HORIZONTAL, false)
    val layoutManager1 =
        LinearLayoutManager(application.applicationContext, LinearLayoutManager.HORIZONTAL, false)

    fun closeTemplateListFragment(view: View) {
        LiveDataHandler.setCommand(CommandModel(CLOSE_TEMPLATE_FRAGMENT_COMMAND))
    }

}