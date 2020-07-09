package com.example.healthyapp.features.information.placementList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthyapp.R
import com.example.healthyapp.db.model.entity.Placement
import kotlinx.android.synthetic.main.item_placement.view.*
import java.math.BigDecimal

class PlacementAdapter(
    private val onClick: (Placement) -> Unit
) : RecyclerView.Adapter<PlacementAdapter.PlacementVH>() {

    private val dataSet = arrayListOf<Placement>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PlacementVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_placement, parent, false)
        )

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: PlacementVH, position: Int) {
        holder.bind(dataSet[position])
    }

    fun setItems(list: List<Placement>) {
        dataSet.clear()
        dataSet.addAll(list)
        notifyDataSetChanged()
    }

    inner class PlacementVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(placement: Placement) {
            val context = itemView.context
            itemView.setOnClickListener { onClick.invoke(placement) }
            itemView.placement_number.text =
                context.getString(R.string.placement_number, placement.number)
            itemView.placement_space.text =
                context.getString(R.string.placement_space, placement.getSpace())
//            itemView.placement_wp_number.text =
//                context.getString(R.string.placement_wp_number, item.second)
        }
    }
}