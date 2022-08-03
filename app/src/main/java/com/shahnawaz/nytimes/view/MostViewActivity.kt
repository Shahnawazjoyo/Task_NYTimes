package com.shahnawaz.nytimes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.shahnawaz.nytimes.R
import com.shahnawaz.nytimes.model.Results
import com.shahnawaz.nytimes.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MostViewActivity : AppCompatActivity(),
    SwipeRefreshLayout.OnRefreshListener {


    lateinit var viewModel: ListViewModel
    private var mostViewArticleAdapter:MostViewListAdapter = MostViewListAdapter(::onAlertCLicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instantiateTheViewModel()
    }

    /**
     * Instantiates the view model class
     * Triggers the fetch data from remote method
     */
    private fun instantiateTheViewModel(){
        viewModel  = ViewModelProviders.of(this).get(ListViewModel::class.java)

        viewModel.refresh()
        loading_view.visibility = View.VISIBLE
        article_list.apply {
            layoutManager =
                LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(article_list.context, LinearLayoutManager(context).orientation))
            adapter = mostViewArticleAdapter

        }


        //set on refresh listener
        swipeRefreshLayout.setOnRefreshListener(this)

        //observe the view model if there are changes
        observeViewModel()
    }

    fun onAlertCLicked(mosViewArticle: Results){
        var intent  = Intent(this@MostViewActivity,MovtViewDetailScreen::class.java)
        intent.putExtra("url",mosViewArticle.url)
        startActivity(intent)


    }


    fun observeViewModel(){

        viewModel.mostViewed.observe(this, Observer {mostViewd->
            mostViewd?.let{list->
                loading_view.visibility = View.GONE
                article_list.visibility = View.VISIBLE
                mostViewArticleAdapter.mostViewList = list.results!!
                mostViewArticleAdapter.notifyDataSetChanged()



            }
        })

        viewModel.countryLoadError.observe(this, Observer {isError->
            loading_view.visibility = View.GONE

        })


    }

    /**
     * handles the swipe and refresh function
     */

    override fun onRefresh() {
        swipeRefreshLayout.isRefreshing = false
        viewModel.refresh()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_manu, menu);
        return true;
    }
}
