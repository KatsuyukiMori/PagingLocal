package com.example.paginglocal.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglocal.data.ItemCard
import com.example.paginglocal.databinding.CardItemBinding

class MainListAdapter(
) : PagedListAdapter<ItemCard, MainListAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(CardItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemCard?) {
            binding.apply {
                itemCard = item
            }
        }
    }

    companion object {
        private val TAG = this.javaClass.name + " mori"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemCard>() {
            override fun areItemsTheSame(oldItem: ItemCard, newItem: ItemCard): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ItemCard, newItem: ItemCard): Boolean {
                return oldItem == newItem
            }
        }
    }
}