package com.editor.photo.photoeditor.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.data.constants.*
import com.editor.photo.photoeditor.data.liveData.LiveDataHandler
import com.editor.photo.photoeditor.data.models.BackgroundColorModel
import com.editor.photo.photoeditor.data.models.StickerModel
import com.editor.photo.photoeditor.databinding.ActivityStoryBinding
import com.editor.photo.photoeditor.view.adapter.StoryPagerAdapter
import com.editor.photo.photoeditor.view.fragments.EditTemplateFragment
import com.editor.photo.photoeditor.view.fragments.StickerPageFragment
import com.editor.photo.photoeditor.view.fragments.TemplateFragment
import com.editor.photo.photoeditor.view.fragments.TemplateListFragment
import com.editor.photo.photoeditor.viewModel.StoryViewModel
import kotlinx.android.synthetic.main.activity_story.*

class StoryActivity : AppCompatActivity() {

    lateinit var viewModel: StoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this)[StoryViewModel::class.java]
        val binding: ActivityStoryBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_story)

        binding.viewModel = viewModel
        binding.fragmentManager = supportFragmentManager
        binding.lifecycleOwner = this

        addEditTemplateFragment()
        addStickerPageFragment()
        addTemplateListFragment()
        observeEditFragmentLiveData(viewModel)
    }


    private fun addTemplateListFragment() {
        val fragment = TemplateListFragment.newInstance(null)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flTemplateList, fragment, fragment.tag)
            .commit()
    }


    private fun addEditTemplateFragment() {
        val fragment = EditTemplateFragment.newInstance(null)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.flEdit, fragment, fragment.tag)
            .commit()
    }

    private fun addStickerPageFragment() {
        val fragment = StickerPageFragment.newInstance(null)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.flSticker, fragment, fragment.tag)
            .commit()
    }


    private fun observeEditFragmentLiveData(viewModel: StoryViewModel) {
        LiveDataHandler.editFragmentLiveData.observe(this, Observer {
            when (it.command) {
                CLOSE_COMMAND -> viewModel.closeEditFragment()
                TEXT_COMMAND -> addEditTextInCurrentFragment()
                COLOR_COMMAND -> addColorLayout()
                COLOR_RESULT -> setBackgroundInCurrentFragment(it.data as BackgroundColorModel?)

                CLOSE_TEMPLATE_FRAGMENT_COMMAND -> viewModel.closeTemplateListClick()

                STICKER_COMMAND -> viewModel.openStickerPagerFragment()
                BACKGROUND_COLOR_CLOSE_COMMAND,
                STICKER_CLOSE_COMMAND -> viewModel.closeStickerPagerFragment()
                STICKER_BACK_COMMAND -> viewModel.backStickerPagerFragment()
                ADD_STICKER_COMMAND -> addStickerInCurrentFragment(it.data as StickerModel)
            }

        })
    }

    private fun setBackgroundInCurrentFragment(backgroundColorModel: BackgroundColorModel?) {
        backgroundColorModel?.let {
            val currentFragment = getCurrentFragmentInTemplatePager()
            currentFragment?.setBackgroundColor(backgroundColorModel)
        }

    }

    private fun addColorLayout() {
        val fragment: EditTemplateFragment =
            supportFragmentManager.findFragmentById(R.id.flEdit) as EditTemplateFragment
        fragment.isBackgroundColorListVisible(View.VISIBLE)

    }

    private fun addEditTextInCurrentFragment() {
        val currentFragment = getCurrentFragmentInTemplatePager()
        currentFragment?.addEditText()
    }

    private fun addStickerInCurrentFragment(sticker: StickerModel) {
        val currentFragment = getCurrentFragmentInTemplatePager()
        currentFragment?.addSticker(sticker)
    }

    private fun getCurrentFragmentInTemplatePager(): TemplateFragment? {
        val currentPosition = vpStory.currentItem
        val templateAdapter = vpStory.adapter as StoryPagerAdapter

        return templateAdapter.getFragment(currentPosition)
    }

    override fun onBackPressed() {
        if (viewModel.templateListVisibility.value == View.VISIBLE) {
            viewModel.closeTemplateListClick()
            return
        }
        super.onBackPressed()
    }
}

