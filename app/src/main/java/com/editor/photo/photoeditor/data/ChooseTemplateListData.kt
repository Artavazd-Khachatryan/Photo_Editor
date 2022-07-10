package com.editor.photo.photoeditor.data

import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.data.models.TemplateModel

object ChooseTemplateListData {
    val chooseTemplateList: List<TemplateModel> by lazy { chooseTemplateList() }

    private fun chooseTemplateList() = listOf(
        TemplateModel("${R.drawable.template_list_item1}", 1),
        TemplateModel("${R.drawable.template_list_item2}", 2),
        TemplateModel("${R.drawable.template_list_item2}", 3),
        TemplateModel("${R.drawable.template_list_item1}", 4),
        TemplateModel("${R.drawable.template_list_item1}", 5),
        TemplateModel("${R.drawable.template_list_item2}", 6),
        TemplateModel("${R.drawable.template_list_item1}", 7),
        TemplateModel("${R.drawable.template_list_item2}", 8),
        TemplateModel("${R.drawable.template_list_item2}", 9),
        TemplateModel("${R.drawable.template_list_item2}", 10),
        TemplateModel("${R.drawable.template_list_item1}", 11),
        TemplateModel("${R.drawable.template_list_item1}", 12),
        TemplateModel("${R.drawable.template_list_item2}", 13),
        TemplateModel("${R.drawable.template_list_item1}", 14)
    )
}

