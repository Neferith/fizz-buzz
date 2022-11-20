package com.fizzbuzz.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fizzbuzz.model.FizzbuzzEntity
import javax.inject.Inject

class FizzbuzzPagingSource @Inject
constructor(val entity: FizzbuzzEntity, val fizzbuzzRepository: FizzbuzzRepository) :
// 1 & 2
    PagingSource<Int, String>() {

    companion object {
        const val PAGE_SIZE = 100
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, String> {
        val currentLoadingPageKey = params.key ?: 0
        val res: ArrayList<String> = ArrayList();
        val prevKey = if (currentLoadingPageKey == 0) null else currentLoadingPageKey - 1


        if ((1 + (currentLoadingPageKey) * PAGE_SIZE) < entity.limit) {
            for (index in 1 + currentLoadingPageKey * PAGE_SIZE..(currentLoadingPageKey * PAGE_SIZE + PAGE_SIZE)) {
                res.add(fizzbuzzRepository.generateFitBuzzString(index, entity))
            }
            return LoadResult.Page(
                data = res,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } else {
            return LoadResult.Error(java.lang.Exception("End of paging"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


}