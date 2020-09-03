package com.guapiston.bairesdev.ui.github

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.bairesdev.R
import com.guapiston.bairesdev.model.Repository

class GithubFragment : Fragment(){
    lateinit var recycler : RecyclerView
    lateinit var viewModel: GithubViewModel
    lateinit var adapter : GithubAdapter
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(GithubViewModel::class.java)
        return inflater.inflate(R.layout.fragment_github,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = GithubAdapter()
        recycler = view.findViewById(R.id.rv_github)
        progressBar = view.findViewById(R.id.progressBar)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        viewModel.result.observe(viewLifecycleOwner, Observer {
            showRepositoryList(it)
        })
    }

    private fun showRepositoryList(list :List<Repository>){
        adapter.setList(list)
        adapter.notifyDataSetChanged()
        progressBar.visibility = View.GONE
    }

    companion object{
        var instance = GithubFragment()
    }
}