package com.example.kotlininlineclass.api

import com.example.kotlininlineclass.db.TestId
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main() {
    val dispatcher: Dispatcher = object : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return when (request.path) {
                "/test/123" -> MockResponse().setBody("""{"id":42}""").setResponseCode(200)
                else -> MockResponse().setResponseCode(404)

            }
        }
    }
    val mockWebServer = MockWebServer()
    mockWebServer.dispatcher = dispatcher
    try {
        mockWebServer.start()

        val okHttpClient = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(mockWebServer.url("/").toString())
            .client(okHttpClient)
            .build()

        val testService = retrofit.create(TestService::class.java)

        runBlocking {
            val testIdResponse: TestId = testService.getTestId(TestId(123))
            val id = testIdResponse.id

            val testResponse: TestResponse = testService.getTestResponse(TestId(123))
            val id2 = testResponse.id.id
            assert(id == id2)
        }

    } catch (e: Exception) {
        e.printStackTrace()

    } finally {
        mockWebServer.shutdown()
    }

}
