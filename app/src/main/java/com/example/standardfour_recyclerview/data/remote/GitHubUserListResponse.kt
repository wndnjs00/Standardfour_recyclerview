package com.example.standardfour_recyclerview.data.remote

import com.google.gson.annotations.SerializedName

// 서버 데이터를 data class로 mapping
data class GitHubUserListResponse(
    @SerializedName("items") val items : List<GitHubUserResponse>
)


// json에 있는 데이터중 내가 가져오고싶은 데이터만 적어줘도돰
data class GitHubUserResponse(
    @SerializedName("avatar_url") val avatarUrl : String,
    @SerializedName("login") val loginName : String
)
