package com.hedgdifuse.alefapp.router

import com.hedgdifuse.alefapp.Constants.LIST_ENDPOINT
import retrofit2.http.GET

/**
 * [RetrofitRouterI] - simple router for retrofit library
 */
interface RetrofitRouterI {

    @GET(LIST_ENDPOINT)
    suspend fun images(): List<String>
}