package com.example.standardfour_recyclerview.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standardfour_recyclerview.databinding.ActivityMainBinding
import com.example.standardfour_recyclerview.extension.launchActivity
import com.example.standardfour_recyclerview.presentation.detail.DetailActivity
import com.example.standardfour_recyclerview.presentation.model.CardModel
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // onClick메소드가 실행되면 람다식이 바로 실행되도록
    private val cardAdapter : CardViewAdapter by lazy {
        CardViewAdapter(cardList = ArrayList<CardModel>()) { card ->
            // DetailActivity로 이동하는 함수 실행
            adapterClick(card)
        }
    }

    // ViewModel 선언
    private val cardViewModel by viewModels<CardViewModel>{
        CardViewModelFactory()
    }

    private lateinit var cardLists : List<CardModel>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        dataFormat()
        initViewModel()
        initData()

    }


    // viewModel가져옴
    private fun initData(){
        cardViewModel.getBlueCardModel()
    }


    private fun initView(){
        cardAdapter.cardList = cardLists
        with(binding.recyclerview){
            adapter = cardAdapter   // 리사이클러뷰와 어뎁터 연결
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initViewModel(){
        // viewModel가져옴 (data update 처리)
        cardViewModel.getBlueCardModel.observe(this@MainActivity){
            cardLists = it

            initView()
        }
    }

    private fun dataFormat(){
        binding.priceTv.text = "$ ${DecimalFormat("#,##0.00").format(285856.20)}"
    }


    private fun adapterClick(card : CardModel){

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
