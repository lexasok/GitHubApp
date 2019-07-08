package net.ozero.githubapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil

interface BaseListAdapterInterface<T: Any> {
    fun update(newList: List<T>, callBack: DiffUtil.Callback)
}