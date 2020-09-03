package com.guapiston.bairesdev.ui.github

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.guapiston.bairesdev.R
import com.guapiston.bairesdev.model.Language
import com.guapiston.bairesdev.model.Repository
import com.squareup.picasso.Picasso


class GithubAdapter : RecyclerView.Adapter<GithubAdapter.GithubViewHolder>(), View.OnClickListener{
    val list = mutableListOf<Repository>()
    class GithubViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tv_repo_nombre_value)
        val tvOwner = view.findViewById<TextView>(R.id.tv_repo_owner_value)
        val ivLanguage = view.findViewById<ImageView>(R.id.iv_language)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        return GithubViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_github,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val repo = list[position]
        holder.tvName.text = repo.name
        holder.tvOwner.text = repo.owner.login
        if(repo.language == null ) Picasso.get().load(R.drawable.question).into(holder.ivLanguage)
        else when(repo.language){
            Language.Kotlin -> Picasso.get().load(R.drawable.kotlin).into(holder.ivLanguage)
            Language.Java -> Picasso.get().load(R.drawable.java).into(holder.ivLanguage)
        }
        holder.itemView.tag = repo
        holder.itemView.setOnClickListener(this)
    }

    fun setList(list : List<Repository>){
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onClick(view: View?) {
        val repo = view?.tag as Repository
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(repo.htmlUrl))
        startActivity(view.context,browserIntent,null)
    }
}