package com.slayton.msu.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.slayton.msu.photogallery.api.GalleryItem
import com.slayton.msu.photogallery.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem) {
        binding.itemImageView.load(galleryItem.url)
        }
    }

// PhotoListAdapter Extends PagingDataAdapter, takes the DiffCallback as a param
class PhotoListAdapter(diffCallback: DiffUtil.ItemCallback<GalleryItem>) :
    PagingDataAdapter<GalleryItem, PhotoViewHolder>(diffCallback) {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }
}

