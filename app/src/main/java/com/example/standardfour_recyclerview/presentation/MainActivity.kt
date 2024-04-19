package com.example.standardfour_recyclerview.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standardfour_recyclerview.ViewModel.CardViewModel
import com.example.standardfour_recyclerview.ViewModel.CardViewModelFactory
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.data.CardDataList
import com.example.standardfour_recyclerview.data.DataSource
import com.example.standardfour_recyclerview.databinding.ActivityMainBinding
import com.example.standardfour_recyclerview.extension.launchActivity
import java.text.DecimalFormat
import java.util.zip.DataFormatException

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // onClick메소드가 실행되면 람다식이 바로 실행되도록
    private val cardAdapter : CardViewAdpater by lazy {
        CardViewAdpater(cardList = ArrayList<CardData>()) { card ->
            // DetailActivity로 이동하는 함수 실행
            adapterClick(card)
        }
    }

    // ViewModel 선언
    private val cardViewModel by viewModels<CardViewModel>{
        CardViewModelFactory()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // DataSource를 통해 가져왔던부분을 ViewModel을 사용해서 받아와줌
        val cardLists = cardViewModel.cardData      // val dataSource = DataSource.getDataSoures().getCardList()
        cardAdapter.cardList = cardLists                          // cardAdapter.cardList = dataSource


        with(binding.recyclerview){
            adapter = cardAdapter   // 리사이클러뷰와 어뎁터 연결
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.priceTv.text = "$ ${DecimalFormat("#,##0.00").format(285856.20)}"

    }


    private fun adapterClick(card : CardData){

        // 1) 그냥 intent사용해서 이동
//        val intent = Intent(this@MainActivity, DetailActivity::class.java)
//        // bundle로 데이터 전달
//        val bundle = Bundle()
//        // 지정해둔 키값을 사용해서 넘기기
//        bundle.putParcelable(DetailActivity.EXTRA_CARD, card)
//        intent.putExtras(bundle)
//        Log.d(TAG, bundle.toString())
//
//        startActivity(intent)


        // 2) Intent부분을 확장함수로 빼서 DetailActivity로 이동하도록 구현
        launchActivity<DetailActivity>(
            DetailActivity.EXTRA_CARD to card
        )


    }

}
