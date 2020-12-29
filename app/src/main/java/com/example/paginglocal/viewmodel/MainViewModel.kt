package com.example.paginglocal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paginglocal.data.CardDataSourceFactory
import com.example.paginglocal.data.ItemCard

class MainViewModel : ViewModel() {

    companion object {
        private val TAG = this.javaClass.name + " mori"
    }

    var cardPagedList: LiveData<PagedList<ItemCard>>? = null // サンプルのため明示的にnullを記載

    init {
        val cardDataSourceFactory = CardDataSourceFactory()
        val pageListConfig = PagedList.Config.Builder()
            .setPageSize(3)
            .setEnablePlaceholders(false)
            .build()
        cardPagedList = LivePagedListBuilder(cardDataSourceFactory, pageListConfig)
            .build()
    }

}