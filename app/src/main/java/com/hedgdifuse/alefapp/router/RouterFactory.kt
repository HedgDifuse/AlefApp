package com.hedgdifuse.alefapp.router

import com.hedgdifuse.alefapp.Constants.START_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * [RouterFactory] - simple factory for create retrofit interfaces from generic type.
 */
object RouterFactory {

    inline fun <reified T> create(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(START_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(T::class.java)
    }
}