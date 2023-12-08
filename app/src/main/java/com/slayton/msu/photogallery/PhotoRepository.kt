package com.slayton.msu.photogallery

import com.slayton.msu.photogallery.api.FlickrApi
import com.slayton.msu.photogallery.api.GalleryItem
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
}