package com.example.standardfour_recyclerview.data.remote

import com.google.gson.annotations.SerializedName


data class GitHubUserListResponse(
    @SerializedName("items") val items : List<GitHubUserResponse>
)


// json에 있는 데이터중 내가 가져오고싶은 데이터만 적어줘도됨
data class GitHubUserResponse(
    @SerializedName("avatar_url") val avatarUrl : String,
    @SerializedName("login") val loginName : String,
    @SerializedName("id") val id : Int      // id값도 생성해서 고유값으로 지정하도록
)
