package com.example.myapplication.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemVehicleBinding
import com.example.myapplication.model.Vehicle

class VehicleAdapter : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    fun interface OnItemClicked {
        fun vehicleClicked(vehicle: Vehicle)
    }

    var itemClicked: OnItemClicked? = null

    var listVehicles: List<Vehicle> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVehicleBinding.inflate(inflater, parent, false)
        return VehicleViewHolder(binding, itemClicked)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val item = listVehicles[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listVehicles.size

    class VehicleViewHolder(
        val binding: ItemVehicleBinding,
        val itemClicked: OnItemClicked?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(vehicle: Vehicle) {
            binding.textPlate.text = vehicle.plate
            binding.root.setOnClickListener {
                itemClicked?.vehicleClicked(vehicle)
            }
        }
    }
}