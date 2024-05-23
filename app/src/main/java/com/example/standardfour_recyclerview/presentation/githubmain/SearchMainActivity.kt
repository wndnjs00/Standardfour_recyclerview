package com.example.standardfour_recyclerview.presentation.githubmain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.standardfour_recyclerview.databinding.ActivitySearchMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchMainActivity : AppCompatActivity() {
    private val binding: ActivitySearchMainBinding by lazy {
        ActivitySearchMainBinding.inflate(layoutInflater)
    }

    private val viewPagerAdapter by lazy {
        SearchMainViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        viewPager.adapter = viewPagerAdapter
        //viewPager에 화면 수 세팅
        viewPager.offscreenPageLimit = viewPagerAdapter.itemCount

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()
    }

}