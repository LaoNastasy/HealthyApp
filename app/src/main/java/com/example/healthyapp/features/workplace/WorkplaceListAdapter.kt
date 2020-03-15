package com.example.healthyapp.features.workplace

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyapp.R
import com.example.healthyapp.db.model.entity.Workplace

class WorkplaceListAdapter : RecyclerView.Adapter<WorkplaceListAdapter.WorkplaceVH>() {

    private val workplaceList = ArrayList<Workplace>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkplaceVH {
        return WorkplaceVH(View.inflate(parent.context, R.layout.view_workplace_item, parent))
    }

    override fun getItemCount() = workplaceList.size

    override fun onBindViewHolder(holder: WorkplaceVH, position: Int) =
        holder.bind(workplaceList[position])

    fun setItems(items: List<Workplace>) {
        workplaceList.clear()
        workplaceList.addAll(items)
        notifyDataSetChanged()
    }

    class WorkplaceVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(workplace: Workplace) {

        }
    }
}