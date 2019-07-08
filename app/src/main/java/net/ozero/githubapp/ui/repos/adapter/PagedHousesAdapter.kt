package net.ozero.githubapp.ui.repos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_repo.view.*
import net.ozero.githubapp.R
import net.ozero.githubapp.entity.Repo
import net.ozero.githubapp.ui.adapter.*

class PagedHousesAdapter : BasePagedListAdapter<HousesPagedViewHolder, Repo>(HousesPagedCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HousesPagedViewHolder =
        HousesPagedViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
        )
}

class HousesPagedViewHolder(view: View) : BasePagedViewHolder<Repo>(view) {
    override fun bind(items: List<Repo>, position: Int) {
        itemView.item_repo_name.text = items[position].repoName
    }
}

class HousesPagedCallback : BasePagingItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean =
        oldItem.repoName == newItem.repoName

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean  =
        oldItem == newItem
}

