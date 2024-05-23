package com.example.standardfour_recyclerview.presentation.githubmain

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.standardfour_recyclerview.presentation.favorite.GitHubFavorateUsersFragment
import com.example.standardfour_recyclerview.presentation.search.main.GitHubSearchUsersFragment
import com.example.standardfour_recyclerview.R

class SearchMainViewPagerAdapter(
    fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = listOf(
        SearchMainTabModel(GitHubSearchUsersFragment.newInstance(), R.string.search_tab_search_title),
        SearchMainTabModel(GitHubFavorateUsersFragment.newInstance(), R.string.search_tab_favorite_title),
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position].fragment

    fun getTitle(position: Int): Int = fragments[position].title
}