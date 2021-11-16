package com.example.kotlininlineclass.api

import com.example.kotlininlineclass.db.TestId
import retrofit2.http.GET
import retrofit2.http.Path

data class TestResponse(val id: TestId)

interface TestService {
    @GET("/test/{testId}")
    suspend fun getTestId(@Path("testId") testId: TestId): TestId

    @GET("/test/{testId}")
    suspend fun getTestResponse(@Path("testId") testId: TestId): TestResponse
}
