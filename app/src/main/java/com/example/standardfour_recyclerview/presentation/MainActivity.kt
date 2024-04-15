package com.example.standardfour_recyclerview.presentation

import android.content.Intent
import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standardfour_recyclerview.R
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.data.CardDataList
import com.example.standardfour_recyclerview.data.DataSource
import com.example.standardfour_recyclerview.databinding.ActivityMainBinding

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
        cardAdapter.cardList = datasource

        with(binding.recyclerview){
            adapter = cardAdapter
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // 클릭 이벤트
        cardAdapter.itemClick = itemClick()
    }


    private fun itemClick() : CardViewAdpater.ItemClick{
        return object : CardViewAdpater.ItemClick{
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)

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
