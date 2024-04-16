package com.example.standardfour_recyclerview.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardfour_recyclerview.R
import com.example.standardfour_recyclerview.data.CardData
import com.example.standardfour_recyclerview.data.Multidata.Companion.MULTI_VIEWTYPE1
import com.example.standardfour_recyclerview.data.Multidata.Companion.MULTI_VIEWTYPE2
import com.example.standardfour_recyclerview.data.Multidata.Companion.MULTI_VIEWTYPE3
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem1Binding
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem2Binding
import com.example.standardfour_recyclerview.databinding.RecyclerviewItem3Binding
import java.text.DecimalFormat

class CardViewAdpater(var cardList : ArrayList<CardData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ItemClick {
        fun onItemClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            MULTI_VIEWTYPE1 -> {
                val binding = RecyclerviewItem1Binding.inflate(inflater, parent, false)
                CardViewHolder1(binding)
            }
            MULTI_VIEWTYPE2 -> {
                val binding = RecyclerviewItem2Binding.inflate(inflater, parent, false)
                CardViewHolder2(binding)
            }
            MULTI_VIEWTYPE3 -> {
                val binding = RecyclerviewItem3Binding.inflate(inflater, parent, false)
                CardViewHolder3(binding)
            }
            else -> throw IllegalAccessException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun getItemViewType(position: Int): Int {
        return cardList[position].type
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cardlist = cardList[position]

        when(holder){
            is CardViewHolder1 -> holder.bind1(cardlist)
            is CardViewHolder2 -> holder.bind2(cardlist)
            is CardViewHolder3 -> holder.bind3(cardlist)

            }

        holder.itemView.setOnClickListener {
            itemClick?.onItemClick(it, position)
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
                cardPriceTv3.text = "$" + DecimalFormat("#,##0.00").format(card.price).toString()
            }
        }
    }

}