package com.pouyaheydari.appupdater.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pouyaheydari.appupdater.core.data.model.StoreListItem
import com.pouyaheydari.appupdater.databinding.DownloadDirectItemBinding

/**
 * Adapter to show Direct download links
 */
internal class DirectRecyclerAdapter(
    private val list: List<StoreListItem>,
    private val typeface: Typeface?,
    private val listener: (StoreListItem) -> Unit,
) : RecyclerView.Adapter<DirectRecyclerAdapter.SoresViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoresViewHolder =
        DownloadDirectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run { SoresViewHolder(this) }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SoresViewHolder, position: Int) = holder.onBind(list[position])

    /**
     * Direct download ViewHolder
     */
    inner class SoresViewHolder(private val binding: DownloadDirectItemBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds data to layout
         */
        fun onBind(item: StoreListItem) {
            val txtDirect = binding.txtDirect
            txtDirect.text = item.title
            typeface?.let { txtDirect.typeface = it }
            binding.root.setOnClickListener { listener(item) }
        }
    }
}
