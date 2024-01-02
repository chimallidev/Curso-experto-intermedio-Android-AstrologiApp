package com.chimallidigital.astrologiapp.data.network

import com.chimallidigital.astrologiapp.BuildConfig.BASE_URL
import com.chimallidigital.astrologiapp.data.core.interceptors.AuthInterceptor
import com.chimallidigital.astrologiapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient{
        val interceptor= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }
    @Provides
    fun provideAstrologiAPIService(retrofit: Retrofit): AstrologiAPIService{
        return retrofit.create(AstrologiAPIService::class.java)
    }
    @Provides
    fun provideRespository(apiService: AstrologiAPIService): Repository{
        return RepositoryImpl(apiService)
    }
}