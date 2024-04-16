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
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Bundle을 사용해서 전달한 데이터 받아옴
        val intent = getIntent()
        val cardItem = intent?.getParcelableExtra<CardData>("card")

        with(binding) {
            detailCardnameTv.text = "이름: ${cardItem?.name}"
            detailCardnunberTv.text = "카드번호: ${cardItem?.number}"
            detailDateTv.text = "유효기간: ${cardItem?.date}"
            detailPriceTv.text = "가격: $${DecimalFormat("#,##0.00").format(cardItem?.price)}"
        }

    }
}