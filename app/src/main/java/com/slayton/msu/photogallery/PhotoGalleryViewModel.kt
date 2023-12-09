package com.slayton.msu.photogallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.slayton.msu.photogallery.api.GalleryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "PhotoGalleryViewModel"

class PhotoGalleryViewModel : ViewModel() {
    private val photoRepository = PhotoRepository()

    // change galleryItems to a Flow of PagingData instead of a MutableList
//    call from pagingGetPhotos rather than fetchPhotos
    val galleryItems: Flow<PagingData<GalleryItem>> = photoRepository.pagingGetPhotos()

    init {
        viewModelScope.launch {
            try {
                // start on page 1 upon initialization
                val items = photoRepository.fetchPhotos(1)
//                Log.d(TAG, "Items received: $items")
            } catch (ex: Exception) {
                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }
}
