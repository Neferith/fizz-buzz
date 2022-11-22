package com.fizzbuzz.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fizzbuzz.domain.GetFizzbuzzStringUseCase
import com.fizzbuzz.model.FizzbuzzEntity
import javax.inject.Inject


fun Long.maximize(limit: Long): Long = if (this < limit) this else limit

class FizzbuzzPagingSource @Inject
constructor(
    val entity: FizzbuzzEntity,
    private val getFizzbuzzStringUseCase: GetFizzbuzzStringUseCase
) :
    PagingSource<Long, String>() {

    companion object {
        const val PAGE_SIZE = 100
    }

    override suspend fun load(params: LoadParams<Long>):
            LoadResult<Long, String> {
        val currentLoadingPageKey = params.key ?: 0
        val res: ArrayList<String> = ArrayList()
        val prevKey = if (currentLoadingPageKey == 0.toLong()) null else currentLoadingPageKey - 1

        val currentIndex = (1 + (currentLoadingPageKey) * PAGE_SIZE)
        return if (currentIndex < entity.limit) {
            val lastIndex = (currentLoadingPageKey * PAGE_SIZE + PAGE_SIZE).maximize(entity.limit)
            for (index in currentIndex..lastIndex) {
                res.add(getFizzbuzzStringUseCase.invoke(index, entity))
            }
            LoadResult.Page(
                data = res,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } else {
            LoadResult.Error(java.lang.Exception("End of paging"))
        }
    }

    override fun getRefreshKey(state: PagingState<Long, String>): Long? {

        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}