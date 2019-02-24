package com.example.retrofit

import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.retrofit.model.AnekdotModel

import org.jetbrains.anko.find


class PostsAdapter(private val posts: List<AnekdotModel>?) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts!![position]
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.post.text = Html.fromHtml(post.elementPureHtml, Html.FROM_HTML_MODE_LEGACY)
        } else {
            holder.post.text = Html.fromHtml(post.elementPureHtml)
        }
        holder.site.text = post.site
    }

    override fun getItemCount(): Int {
        return posts?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var post = itemView.find<TextView>(R.id.postitem_post)
        var site = itemView.find<TextView>(R.id.postitem_site)

    }
}
