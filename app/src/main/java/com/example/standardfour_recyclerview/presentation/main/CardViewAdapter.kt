package com.example.standardfour_recyclerview.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem1Binding
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem2Binding
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem3Binding
import com.example.standardfour_recyclerview.databinding.UnknonItemBinding
import com.example.standardfour_recyclerview.presentation.model.CardModel
import java.text.DecimalFormat

class CardViewAdapter(var cardList : List<CardModel>, private val onClick : (CardModel) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 레이아웃 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        // MultiViewEnum.BlUE.viewType 이런식으로 안쓰고 바로 MultiViewEnum.BlUE 이렇게 쓸수있게 하는 방법
        // entries를 쓰면 MultiViewEnum에 있는 값들이 리스트형식으로 쭉나옴
        val multiViewType = MultiViewEnum.entries.find { it.viewType == viewType}

        return when(multiViewType){
            MultiViewEnum.BlUE -> {
                val binding = RecyclerviewItem1Binding.inflate(inflater, parent, false)
                BlueTypeViewHolder(binding)
            }
            MultiViewEnum.LIGHTBLUE -> {
                val binding = RecyclerviewItem2Binding.inflate(inflater, parent, false)
                LightBlueTypeViewHolder(binding)
            }
            MultiViewEnum.ORANGE -> {
                val binding = RecyclerviewItem3Binding.inflate(inflater, parent, false)
                OrangeTypeViewHolder(binding)
            }
            else -> {
                val binding = UnknonItemBinding.inflate(inflater, parent, false)
                UnknownViewHolder(binding)
            }
        }
    }

    // 아이템 개수 리턴
    override fun getItemCount(): Int {
        return cardList.size
    }


    // 멀티뷰타입은 getItemViewType을 오버라이딩 해줘야함
    // postion에 따라 어떤 뷰타입을 가져야되는지 연결해줘야함
    override fun getItemViewType(position: Int): Int {
        return cardList[position].type.viewType
    }


    // 데이터 연결
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cardlist = cardList[position]

        when(holder.itemViewType){

            MultiViewEnum.BlUE.viewType -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(cardlist)

                // MULTI_VIEWTYPE1 클릭 이벤트 처리 (멀티뷰타입마다 데이터가 완전 다른 경우도 있기 때뮨에 그런경우에는 이렇게 클릭이벤트를 주는게 유용함)
                holder.itemView.setOnClickListener {
                    onClick(cardlist)
                }
            }

            MultiViewEnum.LIGHTBLUE.viewType -> {
                val lightBlueHolder = holder as LightBlueTypeViewHolder
                lightBlueHolder.bind(cardlist)

                // MULTI_VIEWTYPE2 클릭 이벤트 처리
                holder.itemView.setOnClickListener {
                    onClick(cardlist)
                }
            }

            MultiViewEnum.ORANGE.viewType -> {
                val orangeHolder = holder as OrangeTypeViewHolder
                orangeHolder.bind(cardlist)

                // MULTI_VIEWTYPE3 클릭 이벤트 처리
                holder.itemView.setOnClickListener {
                    onClick(cardlist)
                }
            }

        }


    }


    class BlueTypeViewHolder(private val binding : RecyclerviewItem1Binding) : RecyclerView.ViewHolder(binding.root){

        fun bind(card: CardModel){
            with(binding){
                AndersonTv.text = card.name
                debitCardTv.text = card.cardName
                cardNumberTv.text = card.number
                cardDateTv.text = card.date
                cardPriceTv.text = "$" + DecimalFormat("#,##0.00").format(card.price).toString()
            }
        }
    }


    class LightBlueTypeViewHolder(private val binding : RecyclerviewItem2Binding) : RecyclerView.ViewHolder(binding.root){

        fun bind(card: CardModel){
            with(binding){
                AndersonTv2.text = card.name
                debitCardTv2.text = card.cardName
                cardNumberTv2.text = card.number
                cardDateTv2.text = card.date
                cardPriceTv2.text = "$" + DecimalFormat("#,##0.00").format(card.price).toString()
            }
        }
    }


    class OrangeTypeViewHolder(private val binding : RecyclerviewItem3Binding) : RecyclerView.ViewHolder(binding.root){

        fun bind(card : CardModel){
            with(binding){
                AndersonTv3.text = card.name
                debitCardTv3.text = card.cardName
                cardNumberTv3.text = card.number
                cardDateTv3.text = card.date
                cardPriceTv3.text = "$" + DecimalFormat("#,##0.00").format(card.price).toString()
            }
        }
    }


    // 예외처리시, 보여줄 아이템뷰홀더
    class UnknownViewHolder(binding : UnknonItemBinding) : RecyclerView.ViewHolder(binding.root){
        // 아무것도 안보내니깐 일단 Unit으로 설정해둠
        fun bind() = Unit
    }

}