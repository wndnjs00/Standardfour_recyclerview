package com.example.standardfour_recyclerview.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standardfour_recyclerview.R
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.data.DataSource
import com.example.standardfour_recyclerview.databinding.ActivityDetailBinding
import com.example.standardfour_recyclerview.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = getIntent()
        val cardItem = intent?.getParcelableExtra<CardData>("card")

        with(binding) {
            detailCardnameTv.text = cardItem?.name
            detailCardnunberTv.text = cardItem?.number
            detailDateTv.text = cardItem?.date
            detailPriceTv.text = cardItem?.price.toString()
        }

    }
}