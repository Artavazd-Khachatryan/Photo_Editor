package com.editor.photo.photoeditor.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.editor.photo.photoeditor.exceptions.StickerListNotFoundException
import com.editor.photo.photoeditor.data.constants.GRAPHICS
import com.editor.photo.photoeditor.data.constants.OBJECTS
import com.editor.photo.photoeditor.data.constants.STAMP
import com.editor.photo.photoeditor.data.constants.STICKER_KEY
import com.editor.photo.photoeditor.data.models.StickerModel
import com.editor.photo.photoeditor.view.fragments.StickerListFragment

class StickerPagerAdapter(
    fragmentManager: FragmentManager,
    private val stickerMap: Map<String, List<StickerModel>>
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        val bundle = Bundle()
        val key: String = getStickerMapKey(position)
        bundle.putString(STICKER_KEY, key)

        return StickerListFragment.newInstance(bundle)
    }

    private fun getStickerMapKey(position: Int) = when (position) {
        0 -> GRAPHICS
        1 -> STAMP
        2 -> OBJECTS
        else -> throw StickerListNotFoundException("Your key not found.")
    }

    override fun getCount(): Int = stickerMap.size
}