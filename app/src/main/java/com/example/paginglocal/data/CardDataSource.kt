package com.example.paginglocal.data

import android.util.Log
import androidx.paging.PageKeyedDataSource

class CardDataSource(
) : PageKeyedDataSource<Int, ItemCard>() {

    companion object {
        private val TAG = this.javaClass.name + " mori"
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ItemCard>
    ) {
        Log.d(TAG, "loadInitial")
        val list = mutableListOf(
            ItemCard(0, "A"), ItemCard(1, "B"), ItemCard(2, "C")
        )
        callback.onResult(
            list,
            null,
            2
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ItemCard>) {
        Log.d(TAG, "loadAfter, params.key: ${params.key}")
        val list = when (params.key) {
            2 -> {
                mutableListOf(ItemCard(3, "D"), ItemCard(4, "E"), ItemCard(5, "F"))
            }
            3 -> {
                mutableListOf(ItemCard(6, "G"), ItemCard(7, "H"), ItemCard(8, "I"))
            }
            4 -> {
                mutableListOf(ItemCard(9, "J"), ItemCard(10, "K"), ItemCard(11, "L"))
            }
            5 -> {
                mutableListOf(ItemCard(12, "M"), ItemCard(13, "N"), ItemCard(14, "O"))
            }
            6 -> {
                mutableListOf(ItemCard(15, "P"), ItemCard(16, "Q"), ItemCard(17, "R"))
            }
            else -> {
                mutableListOf(ItemCard(997, "Thank you"), ItemCard(998, "For"), ItemCard(999, "Scrolling!!"))
            }
        }
        Log.d(TAG, "callback list: $list")
        callback.onResult(
            list,
            params.key + 1
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ItemCard>) {
        Log.d(TAG, "loadBefore")
    }
}