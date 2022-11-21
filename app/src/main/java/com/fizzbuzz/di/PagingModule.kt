package com.fizzbuzz.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.fizzbuzz.data.repository.FizzbuzzPagingSource
import com.fizzbuzz.data.repository.FizzbuzzRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PagingModule {

    @Provides
    fun providePagingConfig(): PagingConfig {
        return PagingConfig(pageSize = FizzbuzzPagingSource.PAGE_SIZE)
    }

    @Provides
    fun providePager(repository: FizzbuzzRepository, config: PagingConfig): Pager<Int, String> {
        return Pager(config) {
            FizzbuzzPagingSource(repository.loadCurrentFizzBuzzEntity(), repository)
        }
    }
}