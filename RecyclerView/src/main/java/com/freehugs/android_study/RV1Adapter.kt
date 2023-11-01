package com.freehugs.android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RV1Adapter(var items: MutableList<String>) : RecyclerView.Adapter<RV1Adapter.ViewHolder>() {

    //RecyclerView Item 가져오기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RV1Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv1_item, parent, false)
        return ViewHolder(view)
    }

    //가져온 Item을 가지고 ViewBinding 실시 => items
    override fun onBindViewHolder(holder: RV1Adapter.ViewHolder, position: Int) {
        //Item 클릭값이 null이 아니라면 Item을 볼 수 있도록
        if(itemClick != null){
            holder.itemView.setOnClickListener{
                    v -> itemClick?.onClick(v, position)
            }
        }

        //position = Item 값들을 변경될 때마다 가져와 ViewHolder에서 Binding 할 수 있게 도움
        holder.bindItems(items[position])
    }

    //전체 RecyclerView의 개수를 알려줌 - return 값(RecyclerView size) 필수
    override fun getItemCount(): Int {
        return items.size
    }

    //ViewHolder 만들기
    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        fun bindItems(item: String){
            //Adapter의 Item에 들어가 내용 연결하기
            val rv1_text = itemView.findViewById<TextView>(R.id.rv1_text)
            rv1_text.text = item
        }
    }

    //Item 클릭 시 이벤트 발생시키기
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null
}