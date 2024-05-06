package com.example.standardfour_recyclerview.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf
import com.example.standardfour_recyclerview.presentation.model.CardModel


// Intent부분 확장함수로 뽑기
inline fun <reified  T : Any> newIntent(context: Context) : Intent =
    // Intent(this@MainActivity, DetailActivity::class.java) 에 해당하는 부분
    Intent(context, T::class.java)



// 데이터 bundle로 전달하고, startActivity하는 부분도 확장함수로 뽑기
inline fun <reified T : Any> Context.launchActivity(

    // key값은 String , value값은 어떤타입이든 올수있도록 지정
    // vararg(가변인자)로 설정하면 인자를 여러개 넣을 수 있음
    vararg pair: Pair<String, Any>){
    val intent = newIntent<T>(this)
    intent.putExtras(bundleOf(*pair))
    startActivity(intent)
}


// DetailAcitivity에서 데이터 받아오는 부분도 확장함수로 빼기
inline fun <reified T : Any> Activity.extraNotNull(key : String, default : T ?= null) = lazy {

    // intent?.getParcelableExtra<CardData>(EXTRA_CARD)  이코드에 해당하는 부분
    val value = intent?.getParcelableExtra<CardModel>(key)

    // requireNotNull는 null이 아님을 보장하는 함수
    // value가 제네릭타입이 T이면 value리턴, 아니면 default리턴
    requireNotNull(if (value is T) value else default) {key}
}