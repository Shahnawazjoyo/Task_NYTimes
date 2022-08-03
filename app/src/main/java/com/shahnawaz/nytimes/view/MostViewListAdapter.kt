package com.shahnawaz.nytimes.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater

import android.view.ViewGroup
import com.shahnawaz.nytimes.databinding.MostViewArticleBinding
import com.shahnawaz.nytimes.model.Results




class MostViewListAdapter(var callback:(Results)->Unit) : RecyclerView.Adapter<ArticleViewHolder>() {

    var mostViewList: ArrayList<Results> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            MostViewArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = mostViewList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        holder.populateData(mostViewList[position], position)


        holder.itemBinding.root.setOnClickListener {

            callback(mostViewList[holder.index])

        }
    }
}