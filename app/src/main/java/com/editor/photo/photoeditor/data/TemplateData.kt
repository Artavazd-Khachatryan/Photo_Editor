package com.editor.photo.photoeditor.data

import com.editor.photo.photoeditor.data.models.TemplateModel

object TemplateData {

    val templateList: List<TemplateModel> by lazy { createTemplateList() }

    val templateMap: Map<String,List<TemplateModel>> by lazy { createTemplateMap() }

    private fun createTemplateList(): List<TemplateModel>{
        val list = ArrayList<TemplateModel>()

        val templateModel = TemplateModel(android.R.drawable.btn_plus.toString(), 0)
        list += templateModel
        /*list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel
        list += templateModel*/
        return list
    }

    private fun createTemplateMap(): Map<String, List<TemplateModel>>{
        val templateMap = HashMap<String, List<TemplateModel>>()
        templateMap.put("page 1", templateList)

        return templateMap
    }
}