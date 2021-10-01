package com.gb.codingchalleng

class GuideRepository(private val guideApi: GuideApi) {

    suspend fun getGuides(): Resource<Guides> {
        return try {
            Resource.Success(guideApi.getGuides())
        } catch (error: Exception) {
            Resource.Error(error)
        }
    }
}