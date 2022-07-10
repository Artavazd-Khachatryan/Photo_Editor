package com.editor.photo.photoeditor.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.editor.photo.photoeditor.data.models.TemplateModel
import com.editor.photo.photoeditor.databinding.ChooseTemplateListItemBinding
import com.editor.photo.photoeditor.databinding.ChooseTemplateTitleListItemBinding

class ChooseTemplateListAdapter(private var items: List<TemplateModel>) :
    RecyclerView.Adapter<ChooseTemplateListAdapter.ChooseTemplateListViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseTemplateListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ChooseTemplateListItemBinding.inflate(inflater, parent, false)

        return ChooseTemplateListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChooseTemplateListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ChooseTemplateListViewHolder(val binding: ChooseTemplateListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            @SuppressLint("StaticFieldLeak")
            var holder: ChooseTemplateListViewHolder? = null
        }

        lateinit var model: TemplateModel

        fun bind(item: TemplateModel) {
            model = item
            binding.model = model
            binding.holder = this

        }

        fun onClick(view: View) {
            Toast.makeText(view.context, "" + model.id, Toast.LENGTH_SHORT).show()
        }
    }
}