package com.mftadik.cryptokoinapp.service

import com.mftadik.cryptokoinapp.model.Crypto
import retrofit2.Response
import retrofit2.http.GET

interface CryptoAPI {

    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
    // BASE_URL -> https://raw.githubusercontent.com
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    suspend fun getData() : Response<List<Crypto>>

}