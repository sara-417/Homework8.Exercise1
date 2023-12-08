package com.slayton.msu.photogallery.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponse(
    @Json(name = "photo") val galleryItems: List<GalleryItem>,
    // grab the page information
    @Json(name = "page") val page: Int,

//    Right now, the only data you care about in this particular object is the array
//of photo data in the "photo" JSON object. Later in this chapter, you will
//want to capture the paging data if you choose to do the challenge in the
//section called Challenge: Paging.
)
