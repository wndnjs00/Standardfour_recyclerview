package com.example.standardfour_recyclerview.presentation.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.standardfour_recyclerview.R
import com.example.standardfour_recyclerview.databinding.ItemGithubUserBinding
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUser

class FavoriteListAdapter  : RecyclerView.Adapter<FavoriteListAdapter.FavoriteUserViewHolder>(){

    var gitHubUserList = listOf<GitHubUser>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_github_user, parent, false)
        return FavoriteUserViewHolder(ItemGithubUserBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return gitHubUserList.size
    }


    override fun onBindViewHolder(holder: FavoriteUserViewHolder, position: Int) {
        val currentItem = gitHubUserList[position]
        holder.bind(currentItem)
    }


    class FavoriteUserViewHolder(private val binding: ItemGithubUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(gitHubUser : GitHubUser){
            with(binding){
                // 토글버튼 체크됐을때
                switchFavorite.isChecked = gitHubUser.isFavorite

                tvUserName.text = gitHubUser.loginName

                Glide.with(itemView.context)
                    .load(gitHubUser.avatarUrl)
                    .into(imgUserAvatar)
            }
        }
    }
}