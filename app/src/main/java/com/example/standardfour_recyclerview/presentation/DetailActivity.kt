package com.example.standardfour_recyclerview.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.standardfour_recyclerview.ViewModel.CardViewModel
import com.example.standardfour_recyclerview.ViewModel.CardViewModelFactory
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.data.DataSource
import com.example.standardfour_recyclerview.databinding.ActivityDetailBinding
import com.example.standardfour_recyclerview.extension.extraNotNull
import java.text.DecimalFormat


class DetailActivity : AppCompatActivity() {

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    // 어디서나 이 키값을 사용할수있게끔 지정!
    companion object{
        const val EXTRA_CARD : String = "extra_card"
    }

    // 확장함수로 데이터받아오는거 구현한 함수 가져오기
    private val card by extraNotNull<CardData>(EXTRA_CARD)


    // ViewModel 선언
    private val cardViewModel by viewModels<CardViewModel>{
        CardViewModelFactory()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1) Intent로 전달한 데이터 받아옴
//        val intent = getIntent()
//        val cardItem = intent?.getParcelableExtra<CardData>(EXTRA_CARD)
//
//        with(binding) {
//            detailCardnameTv.text = "이름: ${cardItem?.name}"
//            detailCardnunberTv.text = "카드번호: ${cardItem?.number}"
//            detailDateTv.text = "유효기간: ${cardItem?.date}"
//            detailPriceTv.text = "가격: $${DecimalFormat("#,##0.00").format(cardItem?.price)}"
//        }


        // 2) 확장함수로 넘긴 데이터 받아옴
//        val cardData = card
//
//        with(binding) {
//            detailCardnameTv.text = "이름: ${cardData.name}"
//            detailCardnunberTv.text = "카드번호: ${cardData.number}"
//            detailDateTv.text = "유효기간: ${cardData.date}"
//            detailPriceTv.text = "가격: $${DecimalFormat("#,##0.00").format(cardData.price)}"
//        }


        // 3) viewModel 사용
        val cardItem = intent?.getParcelableExtra<CardData>(EXTRA_CARD)
        val cardData = cardItem?.let { cardViewModel.getCardModel(it) }

        with(binding) {
            detailCardnameTv.text = "이름: ${cardData?.name}"
            detailCardnunberTv.text = "카드번호: ${cardData?.number}"
            detailDateTv.text = "유효기간: ${cardData?.date}"
            detailPriceTv.text = "가격: $${DecimalFormat("#,##0.00").format(cardData?.price)}"
        }
    }
}