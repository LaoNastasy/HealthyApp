package com.example.healthyapp.features.information.placementInfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyapp.R
import com.example.healthyapp.db.model.entity.Workplace
import kotlinx.android.synthetic.main.item_workplace.view.*

class WorkplaceAdapter(
    private val onClick: (Workplace) -> Unit
) : RecyclerView.Adapter<WorkplaceAdapter.WorkplaceVH>() {

    private val dataSet = arrayListOf<Workplace>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkplaceVH {
        return WorkplaceVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_workplace,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: WorkplaceVH, position: Int) {
        holder.bind(dataSet[position])
    }

    fun setList(list: List<Workplace>) {
        dataSet.clear()
        dataSet.addAll(list)
        notifyDataSetChanged()
    }


    inner class WorkplaceVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Workplace) {
            itemView.workplace_id.text = itemView.context.getString(R.string.workplace_id, adapterPosition+1)
            itemView.setOnClickListener { onClick.invoke(item) }
        }
    }


}