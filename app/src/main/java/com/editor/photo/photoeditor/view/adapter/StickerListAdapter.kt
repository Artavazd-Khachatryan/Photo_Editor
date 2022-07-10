package com.editor.photo.photoeditor.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.editor.photo.photoeditor.data.constants.ADD_STICKER_COMMAND
import com.editor.photo.photoeditor.data.constants.STICKER_CLOSE_COMMAND
import com.editor.photo.photoeditor.data.liveData.LiveDataHandler
import com.editor.photo.photoeditor.data.models.CommandModel

import com.editor.photo.photoeditor.data.models.StickerModel
import com.editor.photo.photoeditor.databinding.StickerListItemBinding

class StickerListAdapter(private var items: List<StickerModel>) :
    RecyclerView.Adapter<StickerListAdapter.StickerItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StickerListItemBinding.inflate(inflater, parent, false)

        return StickerItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StickerItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


    fun setStickerList(list: List<StickerModel>) {
        items = list
        notifyDataSetChanged()
    }

    inner class StickerItemViewHolder(val binding: StickerListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        lateinit var model: StickerModel

        fun bind(item: StickerModel) {
            model = item
            binding.sticker = model
            binding.holder = this
        }

        fun onClick(view: View) {
            LiveDataHandler.setCommand(CommandModel(STICKER_CLOSE_COMMAND))
            LiveDataHandler.setCommand(CommandModel(ADD_STICKER_COMMAND, model))
        }
    }
}
