package net.ozero.githubapp.ui.listener

import androidx.recyclerview.widget.RecyclerView

class HideButtonScrollListener(
    private val hide: () -> Unit,
    private val show: () -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) {
            hide()
        } else if (dy < 0) {
            show()
        }
    }
}