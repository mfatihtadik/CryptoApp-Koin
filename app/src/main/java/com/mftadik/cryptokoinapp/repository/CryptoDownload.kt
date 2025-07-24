package com.mftadik.cryptokoinapp.repository

import com.mftadik.cryptokoinapp.model.Crypto
import com.mftadik.cryptokoinapp.util.Resource

interface CryptoDownload{
    suspend fun downloadCryptos() : Resource<List<Crypto>>
}