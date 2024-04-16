package com.example.standardfour_recyclerview.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.data.CardDataList
import com.example.standardfour_recyclerview.data.DataSource
import com.example.standardfour_recyclerview.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.util.zip.DataFormatException

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataSource = DataSource.getDataSoures().getCardList()
        cardAdapter.cardList = dataSource as ArrayList<CardData>

        with(binding.recyclerview){
            adapter = cardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.priceTv.text = "$ ${DecimalFormat("#,##0.00").format(285856.20)}"

    }


    private fun adapterClick(card : CardData){
        // MainActivity로 이동
        val intent = Intent(this@MainActivity, DetailActivity::class.java)

        // bundle로 데이터 전달
        val bundle = Bundle()
        bundle.putParcelable("card", card)
        intent.putExtras(bundle)
        Log.d(TAG, bundle.toString())

        startActivity(intent)
    }

}
