package net.ozero.githubapp.ui.adapter

import android.view.View
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BasePagedListAdapter<VH: BasePagedViewHolder<T>, T: Any>(
    callback: BasePagingItemCallback<T>
) : PagedListAdapter<T, VH>(callback) {

    val items = mutableListOf<T>()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items, position)
    }
}

abstract class BasePagedViewHolder<T>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(items: List<T>, position: Int)
}


abstract class BasePagingItemCallback<T> : DiffUtil.ItemCallback<T>()