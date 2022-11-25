package com.fizzbuzz.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import com.fizzbuzz.data.repository.FizzbuzzPagingSource
import com.fizzbuzz.data.repository.FizzbuzzRepository
import com.fizzbuzz.domain.GetFizzbuzzStringUseCase
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
    fun providePagingSource(
        repository: FizzbuzzRepository,
        useCase: GetFizzbuzzStringUseCase
    ): PagingSource<Long, String> {
        return FizzbuzzPagingSource(repository.loadCurrentFizzBuzzEntity(), useCase)
    }

    @Provides
    fun providePager(
        pagingSource: PagingSource<Long, String>,
        config: PagingConfig
    ): Pager<Long, String> {
        return Pager(config) {
            pagingSource
        }
    }
}