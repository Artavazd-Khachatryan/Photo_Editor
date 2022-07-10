package com.editor.photo.photoeditor.view.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.editor.photo.photoeditor.data.models.StickerModel
import com.editor.photo.photoeditor.data.models.TemplateModel

import androidx.cardview.widget.CardView


class BindingAdapter {

    companion object {

        @BindingAdapter(
            value = ["app:pagerAdapterList", "app:fragmentManager", "app:pageTransformer"],
            requireAll = false
        )
        @JvmStatic
        fun setViewPagerAdapterList(
            viewPager: ViewPager,
            templates: List<TemplateModel>,
            fragmentManager: FragmentManager,
            pageTransformer: ViewPager.PageTransformer?
        ) {
            viewPager.adapter = StoryPagerAdapter(fragmentManager, templates)

            pageTransformer?.let { viewPager.setPageTransformer(true, it) }
        }


        @BindingAdapter(
            value = ["app:pagerAdapterMap", "app:fragmentManager", "app:pageTransformer"],
            requireAll = false
        )
        @JvmStatic
        fun setViewPagerAdapterListMap(
            viewPager: ViewPager,
            data: Map<String, List<*>>,
            fragmentManager: FragmentManager,
            pageTransformer: ViewPager.PageTransformer?
        ) {
            when (data[data.keys.first()]!![0]) {
                is TemplateModel -> viewPager.adapter
                is StickerModel -> viewPager.adapter =
                    StickerPagerAdapter(fragmentManager, data as Map<String, List<StickerModel>>)
            }

            pageTransformer?.let { viewPager.setPageTransformer(true, it) }
        }


        @BindingAdapter("app:visibility")
        @JvmStatic
        fun setVisibility(view: View, value: Int) {
            when (value) {
                View.GONE -> view.visibility = View.GONE
                View.VISIBLE -> view.visibility = View.VISIBLE
                View.INVISIBLE -> view.visibility = View.INVISIBLE
            }
        }


        @BindingAdapter("app:colorId")
        @JvmStatic
        fun setColor(view: View, colorID: Int) {
            when (view) {
                is CardView -> view.setCardBackgroundColor(view.context.getColor(colorID))
                else -> view.setBackgroundColor(view.context.getColor(colorID))
            }
        }

    }
}