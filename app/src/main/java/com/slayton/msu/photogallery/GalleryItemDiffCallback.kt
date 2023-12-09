package com.slayton.msu.photogallery

import androidx.recyclerview.widget.DiffUtil
import com.slayton.msu.photogallery.api.GalleryItem


// create the GalleryItemDiffCallback. This seemed to be more for if you are expecting to make updates to your datasource,
// I don't really know what all this class is doing here, but my stuff wouldn't work without it, this is a solution (class) soley given
// to me by ChatGPT
class GalleryItemDiffCallback : DiffUtil.ItemCallback<GalleryItem>() {
    override fun areItemsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
        return oldItem == newItem
    }
}