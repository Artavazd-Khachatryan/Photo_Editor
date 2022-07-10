package com.editor.photo.photoeditor.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.editor.photo.photoeditor.data.models.TemplateModel
import com.editor.photo.photoeditor.view.fragments.TemplateFragment

class StoryPagerAdapter(
    fragmentManager: FragmentManager,
    private val templateModelList: List<TemplateModel>
) : FragmentStatePagerAdapter(fragmentManager) {

    private val map: MutableMap<Int, TemplateFragment> = HashMap()

    override fun getItem(position: Int): Fragment {
        if (map[position] == null) {
            val fragment: TemplateFragment = TemplateFragment.newInstance(null) as TemplateFragment
            map[position] = fragment
            return fragment
        }

        return map[position]!!
    }

    fun getFragment(position: Int) = map[position]

    override fun getCount(): Int = templateModelList.size

}