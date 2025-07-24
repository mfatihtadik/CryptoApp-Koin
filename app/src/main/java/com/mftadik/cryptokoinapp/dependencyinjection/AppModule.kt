package com.mftadik.cryptokoinapp.dependencyinjection

import com.mftadik.cryptokoinapp.repository.CryptoDownload
import com.mftadik.cryptokoinapp.repository.CryptoDownloadImpl
import com.mftadik.cryptokoinapp.service.CryptoAPI
import com.mftadik.cryptokoinapp.viewmodel.CryptoViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    //Singleton
    single {
        val BASE_URL = "https://raw.githubusercontent.com/"

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    single<CryptoDownload> {
        CryptoDownloadImpl(get())
    }

    viewModel {
        CryptoViewModel(get())
    }

    //factory -> everytime we inject -> new instance
    //Her inject ettiğinde yeni bir obje oluşur.
    /*
    factory {
    }
     */
}