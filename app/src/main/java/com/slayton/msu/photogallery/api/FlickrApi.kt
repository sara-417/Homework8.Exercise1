package com.slayton.msu.photogallery.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "f35d3bcd23bd778bee1ef68d1174cd90"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse

}