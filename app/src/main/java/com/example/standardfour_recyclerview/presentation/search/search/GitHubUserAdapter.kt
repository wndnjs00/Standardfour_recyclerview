package com.example.standardfour_recyclerview.presentation.search.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.standardfour_recyclerview.R
import com.example.standardfour_recyclerview.databinding.ItemGithubUserBinding
import com.example.standardfour_recyclerview.presentation.search.model.GitHubUserEntity

class GitHubUserAdapter(private val onClick : (GitHubUserEntity) -> Unit) :  RecyclerView.Adapter<GitHubUserAdapter.GitHubUserViewHolder>(){

    var gitHubUserList = listOf<GitHubUserEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_github_user,parent, false)
        return GitHubUserViewHolder(ItemGithubUserBinding.bind(view), onClick)
    }

    override fun onBindViewHolder(holder: GitHubUserViewHolder, position: Int) {
        val currentItem = gitHubUserList[position]
        holder.bind(currentItem)

        // 아이템 클릭이벤트
        holder.itemView.setOnClickListener {
            onClick(currentItem)
        }
    }

    override fun getItemCount(): Int = gitHubUserList.size


    class GitHubUserViewHolder(private val binding: ItemGithubUserBinding, private val onClick: (GitHubUserEntity) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        fun bind(gitHubUser : GitHubUserEntity) = with(binding){

            // 토글버튼 체크됐을때, isFavorite값 true
            switchFavorite.isChecked = gitHubUser.isFavorite

            tvUserName.text = gitHubUser.loginName

            Glide.with(itemView.context)
                .load(gitHubUser.avatarUrl)
                .into(imgUserAvatar)


            // 토글버튼 클릭시
            switchFavorite.setOnClickListener {

                // != 는 비교연산자 (두항 다르면 true, 같으면 false)
                // 현재 좋아요가 클릭된 상태인지 아닌지 확인 (즐겨찾기 상태가 변경되었는지 확인)
                if (gitHubUser.isFavorite != switchFavorite.isChecked){
                    // 즐겨찾기 상태가 변경되었으면 콜백함수 호출하여 업데이트처리
                    onClick(gitHubUser)
                }
            }
        }
    }
}