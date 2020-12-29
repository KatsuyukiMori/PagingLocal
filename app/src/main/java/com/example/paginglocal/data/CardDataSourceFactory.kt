package com.example.paginglocal.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource


class CardDataSourceFactory(
) : DataSource.Factory<Int, ItemCard>() {

    companion object {
        private val TAG = this.javaClass.name + " mori"
    }

    private val cardDataSourceLiveData = MutableLiveData<CardDataSource>()

    override fun create(): DataSource<Int, ItemCard> {
        Log.d(TAG, "Factory creates dataSource")
        val cardDataSource = CardDataSource()
        cardDataSourceLiveData.postValue(cardDataSource)
        return cardDataSource
    }
}