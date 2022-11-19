package com.fizzbuzz.di

import android.content.Context
import androidx.preference.PreferenceManager
import com.fizzbuzz.data.storage.FizzBuzzStorageImpl
import com.fizzbuzz.data.storage.FizzbuzzStorage
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Singleton
    @Provides
    fun provideStorage(@ApplicationContext appContext: Context, gson: Gson): FizzbuzzStorage {
        return FizzBuzzStorageImpl(PreferenceManager.getDefaultSharedPreferences(appContext), gson)
    }
}