package com.blogspot.devofandroid.covid19tracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.devofandroid.covid19tracker.R
import com.blogspot.devofandroid.covid19tracker.dataClass.GetData


class CaseListAdapter(private val getData: MutableList<GetData>) :
    RecyclerView.Adapter<CaseListAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_design, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val items: GetData = getData[position]
        holder.placeTn.text = items.tamilNadu
        holder.placeUp.text = items.uttarPradesh
        holder.placeWb.text = items.westBengal
        holder.dateCase1.text = items.Date
        holder.dateCase2.text = items.Date
        holder.dateCase3.text = items.Date

    }

    override fun getItemCount(): Int {
        return getData.size

    }


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val placeTn: TextView = itemView.findViewById(R.id.count_case_1)
        val placeUp: TextView = itemView.findViewById(R.id.count_case2)
        val placeWb: TextView = itemView.findViewById(R.id.count_case3)
        val dateCase1: TextView = itemView.findViewById(R.id.date_case_1)
        val dateCase2: TextView = itemView.findViewById(R.id.date_case2)
        val dateCase3: TextView = itemView.findViewById(R.id.date_case3)

    }


}