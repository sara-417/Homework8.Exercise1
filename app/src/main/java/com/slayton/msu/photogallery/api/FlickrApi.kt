package com.slayton.msu.photogallery.api

import retrofit2.http.GET

interface FlickrApi {
    @GET("/")
    suspend fun fetchContents(): String
}