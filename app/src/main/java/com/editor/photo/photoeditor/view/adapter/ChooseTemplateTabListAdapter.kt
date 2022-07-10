package com.editor.photo.photoeditor.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.editor.photo.photoeditor.data.models.CommandModel
import com.editor.photo.photoeditor.data.models.TabListModel
import com.editor.photo.photoeditor.databinding.BackgroundColorItemBinding
import com.editor.photo.photoeditor.databinding.ChooseTemplateTitleListItemBinding

class ChooseTemplateTabListAdapter(private var items: List<TabListModel>) :
    RecyclerView.Adapter<ChooseTemplateTabListAdapter.ChooseTemplateTabListViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseTemplateTabListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ChooseTemplateTitleListItemBinding.inflate(inflater, parent, false)

        return ChooseTemplateTabListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChooseTemplateTabListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


    class ChooseTemplateTabListViewHolder(val binding: ChooseTemplateTitleListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            @SuppressLint("StaticFieldLeak")
            var holder: ChooseTemplateTabListViewHolder? = null
        }

        lateinit var model: TabListModel

        fun bind(item: TabListModel) {
            model = item
            binding.model = model
            binding.holder = this

        }

        fun onClick(view: View) {
        }
    }
}