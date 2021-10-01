package com.gb.codingchalleng

import retrofit2.http.GET

interface GuideApi {

    @GET("v2/upcomingGuides/")
    suspend fun getGuides(): Guides
}