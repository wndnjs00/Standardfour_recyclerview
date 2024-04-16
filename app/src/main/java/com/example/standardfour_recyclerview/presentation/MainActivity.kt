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

    private val cardAdapter = CardViewAdpater(CardDataList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val datasource = DataSource.getDataSoures().getCardList()
        cardAdapter.cardList = datasource as ArrayList<CardData>

        with(binding.recyclerview){
            adapter = cardAdapter
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        binding.priceTv.text = "$ ${DecimalFormat("#,##0.00").format(285856.20)}"

        // 클릭 이벤트
        cardAdapter.itemClick = itemClick()
    }


    private fun itemClick() : CardViewAdpater.ItemClick{
        return object : CardViewAdpater.ItemClick{
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)

                // Bundle을 사용해서 데이터 전달
                val datasource = DataSource.getDataSoures().getCardList()
                val bundle = Bundle()
                bundle.putParcelable("card", datasource[position])
                intent.putExtras(bundle)
                Log.d(TAG, bundle.toString())

                startActivity(intent)
            }
        }
    }

}
