//package com.example.standardfour_recyclerview.presentation.githubmain
//
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import com.example.standardfour_recyclerview.presentation.search.search.SearchViewModel
//import com.example.standardfour_recyclerview.presentation.search.search.SearchViewModelFactory
//
//class GitHubUserActivity : AppCompatActivity() {
//    /*
//    * TODO
//    *  1.create XML  2.viewBinding Setting 3. RecyclerView Setting
//    * */
//
//    private val gitHubUserViewModel by viewModels<SearchViewModel> {
//        SearchViewModelFactory()
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        gitHubUserViewModel.getGitHubUserList()
//
//        gitHubUserViewModel.getGitHubUserList.observe(this@GitHubUserActivity){ gitHubUserList ->
//            Log.d("debug100", gitHubUserList.toString())
//            //TODO 1. check observe data 2. RecyclerView Setting
//        }
//    }
//}