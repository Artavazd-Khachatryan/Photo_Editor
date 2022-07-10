package com.editor.photo.photoeditor.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableInt
import androidx.recyclerview.widget.RecyclerView
import com.editor.photo.photoeditor.data.constants.COLOR_RESULT
import com.editor.photo.photoeditor.data.liveData.LiveDataHandler
import com.editor.photo.photoeditor.data.models.BackgroundColorModel
import com.editor.photo.photoeditor.data.models.CommandModel
import com.editor.photo.photoeditor.databinding.BackgroundColorItemBinding

class BackgroundColorListAdapter(private var items: List<BackgroundColorModel>) :
    RecyclerView.Adapter<BackgroundColorListAdapter.BackgroundColorItemViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BackgroundColorItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BackgroundColorItemBinding.inflate(inflater, parent, false)

        return BackgroundColorItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BackgroundColorItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


    class BackgroundColorItemViewHolder(val binding: BackgroundColorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            @SuppressLint("StaticFieldLeak")
            var holder: BackgroundColorItemViewHolder? = null
        }

        lateinit var model: BackgroundColorModel

        val isItemChecked = ObservableInt(View.INVISIBLE)

        fun bind(item: BackgroundColorModel) {
            model = item
            binding.model = model
            binding.holder = this

        }

        fun onClick(view: View) {
            LiveDataHandler.setCommand(CommandModel(COLOR_RESULT, model))
            setChecked()
        }


        private fun setChecked() {
            if (holder != this) {
                isItemChecked.set(View.VISIBLE)
                holder?.isItemChecked?.set(View.INVISIBLE)
                holder = this
            }
        }
    }
}