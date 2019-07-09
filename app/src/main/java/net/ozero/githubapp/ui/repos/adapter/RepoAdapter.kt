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

class RepoAdapter(
    private val repoPressedListener: (id: Long) -> Unit
) : BaseListAdapter<RepoViewHolder, Repo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder =
        RepoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false),
            repoPressedListener
        )

    fun update(repos: List<Repo>) {
        update(repos, HousesCallback(items, repos))
    }
}


class RepoViewHolder(view: View, private val listener: (id: Long) -> Unit) : BaseViewHolder<Repo>(view) {
    override fun bind(items: List<Repo>, position: Int) {
        val repo = items[position]
        itemView.item_repo_name.text = repo.repoName
        itemView.item_repo_owner_name.text = repo.ownerName
        itemView.setOnClickListener { listener(repo.id) }
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

