package net.ozero.githubapp.ui.repos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.synthetic.main.item_repo.view.*
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.ui.adapter.BaseListAdapter
import net.ozero.githubapp.ui.adapter.BaseViewHolder

class RepoAdapter : BaseListAdapter<RepoViewHolder, Repo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder =
        RepoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        )

    fun update(repos: List<Repo>) {
        update(repos, HousesCallback(items, repos))
    }
}

class RepoViewHolder(view: View) : BaseViewHolder<Repo>(view) {
    override fun bind(items: List<Repo>, position: Int) {
        itemView.item_house_text_address.text = items[position].repoName
    }
}

class HousesCallback(private val oldList: List<Repo>, private val newList: List<Repo>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].repoName == newList[newItemPosition].repoName
}

class HousesItemCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean  =
        oldItem.repoName == newItem.repoName
}

