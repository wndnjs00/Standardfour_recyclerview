package com.example.standardfour_recyclerview.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem1Binding
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem2Binding
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem3Binding
import com.example.standardfour_recyclerview.presentation.enums.MultiViewEnum
import java.text.DecimalFormat

class CardViewAdpater(var cardList : ArrayList<CardData>, private val onClick : (CardData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){

            MultiViewEnum.MULTI_VIEWTYPE1.viewType -> {
                val binding = RecyclerviewItem1Binding.inflate(inflater, parent, false)
                CardViewHolder1(binding)
            }
            MultiViewEnum.MULTI_VIEWTYPE2.viewType -> {
                val binding = RecyclerviewItem2Binding.inflate(inflater, parent, false)
                CardViewHolder2(binding)
            }
            MultiViewEnum.MULTI_VIEWTYPE3.viewType -> {
                val binding = RecyclerviewItem3Binding.inflate(inflater, parent, false)
                CardViewHolder3(binding)
            }
            else -> throw IllegalAccessException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }


    // 멀티뷰타입은 getItemViewType을 설정해줘야함
    // postion에 따라 어떤 뷰타입을 가져야되는지 연결해줘야함
    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> MultiViewEnum.MULTI_VIEWTYPE1.viewType
            1 -> MultiViewEnum.MULTI_VIEWTYPE2.viewType
            2 -> MultiViewEnum.MULTI_VIEWTYPE3.viewType
            else -> throw IllegalAccessException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cardlist = cardList[position]

        when(holder.itemViewType){

            MultiViewEnum.MULTI_VIEWTYPE1.viewType -> {
                val blueHolder = holder as CardViewHolder1
                blueHolder.bind1(cardlist)

                // MULTI_VIEWTYPE1 클릭 이벤트 처리 (멀티뷰타입마다 데이터가 완전 다른 경우도 있기 때뮨에 그런경우에는 이렇게 클릭이벤트를 주는게 유용함)
                holder.itemView.setOnClickListener {
                    onClick(cardlist)
                }
            }

            MultiViewEnum.MULTI_VIEWTYPE2.viewType -> {
                val lightBlueHolder = holder as CardViewHolder2
                lightBlueHolder.bind2(cardlist)

                // MULTI_VIEWTYPE2 클릭 이벤트 처리
                holder.itemView.setOnClickListener {
                    onClick(cardlist)
                }
            }

            MultiViewEnum.MULTI_VIEWTYPE3.viewType -> {
                val orangeHolder = holder as CardViewHolder3
                orangeHolder.bind3(cardlist)

                // MULTI_VIEWTYPE3 클릭 이벤트 처리
                holder.itemView.setOnClickListener {
                    onClick(cardlist)
                }
            }

        }


    }


    inner class CardViewHolder1(private val binding : RecyclerviewItem1Binding) : RecyclerView.ViewHolder(binding.root){

        fun bind1(card : CardData){
            with(binding){
                AndersonTv.text = card.name
                debitCardTv.text = card.cardName
                cardNumberTv.text = card.number
                cardDateTv.text = card.date
                cardPriceTv.text = "$" + DecimalFormat("#,##0.00").format(card.price).toString()
            }
        }
    }


    inner class CardViewHolder2(private val binding : RecyclerviewItem2Binding) : RecyclerView.ViewHolder(binding.root){

        fun bind2(card : CardData){
            with(binding){
                AndersonTv2.text = card.name
                debitCardTv2.text = card.cardName
                cardNumberTv2.text = card.number
                cardDateTv2.text = card.date
                cardPriceTv2.text = "$" + DecimalFormat("#,##0.00").format(card.price).toString()
            }
        }
    }


    inner class CardViewHolder3(private val binding : RecyclerviewItem3Binding) : RecyclerView.ViewHolder(binding.root){

        fun bind3(card : CardData){
            with(binding){
                AndersonTv3.text = card.name
                debitCardTv3.text = card.cardName
                cardNumberTv3.text = card.number
                cardDateTv3.text = card.date
                cardPriceTv3.text = "$" + DecimalFormat("#,##0.00").format(card.price).toString()   // 확장함숧 뽑아보기
            }
        }
    }

}