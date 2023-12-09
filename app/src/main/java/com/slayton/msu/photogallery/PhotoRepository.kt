package com.slayton.msu.photogallery

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.slayton.msu.photogallery.api.FlickrApi
import com.slayton.msu.photogallery.api.GalleryItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {
    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        flickrApi = retrofit.create()
    }

    // add page as a parameter to the PhotoRepository fetchPhotos so
    // that the current page is passed when fetchPhotos is called
    suspend fun fetchPhotos(page: Int): List<GalleryItem> =
        flickrApi.fetchPhotos(page).photos.galleryItems


//    add paging configuration. The challenge said that 100 images were loaded on one page so that's why i chose 100 as the size
//    i didn't know what to do for the distance (3 images per row, 5 rows of images was my thought process) it worked well when i
//    ran it so i didn't see any point in changing.
   private val pagingConfig = PagingConfig(
        pageSize = 100,
        prefetchDistance = 15,
        enablePlaceholders = false
    )

//    create a function to return the Pager so that the work done by PhotoPagingSource can be used.
    fun pagingGetPhotos(): Flow<PagingData<GalleryItem>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { PhotoPagingSource(flickrApi)}
        ).flow
    }
}