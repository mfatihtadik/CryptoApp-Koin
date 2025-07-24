package com.mftadik.cryptokoinapp.repository

import com.mftadik.cryptokoinapp.model.Crypto
import com.mftadik.cryptokoinapp.service.CryptoAPI
import com.mftadik.cryptokoinapp.util.Resource

class CryptoDownloadImpl(private val api : CryptoAPI) : CryptoDownload {

    override suspend fun downloadCryptos(): Resource<List<Crypto>> {
      return try {
          val response = api.getData()
          if (response.isSuccessful) {
              response.body()?.let {
                  return@let Resource.success(it)
              } ?: Resource.error("Error!",null)
              } else {
                  Resource.error("Error!",null)
          }
      } catch (e : Exception) {
          Resource.error("No data", null)
      }
    }
}