package com.example.smartpharm.adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.smartpharm.R
import com.example.smartpharm.models.User
import com.google.gson.Gson

class ListPharmacistsAdapter(val context: FragmentActivity?, var data:List<User>):
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.client_item_pharmacist, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.namePharmacy.text = data[position].company
        holder.locationPharmacy.text = data[position].locationUser
        holder.item.setOnClickListener {

            val pharmacy = data[position]

            val gson = Gson()
            val prefUser = context?.getSharedPreferences("PharmacyProfile", Context.MODE_PRIVATE)
            val editorUser : SharedPreferences.Editor? = prefUser?.edit()
            val json = gson.toJson(pharmacy)
            editorUser?.apply{
                putString("pharmacyProfile",json)
            }?.apply()

            context?.findNavController(R.id.myNavHostFragment)?.navigate(R.id.to_Client_Pharmacy_Detail)

        }
    }


    override fun getItemCount() = data.size
}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val item = view.findViewById(R.id.itemPharmacistClientHome) as View
    val namePharmacy = view.findViewById(R.id.Pharmacy_Name) as TextView
    val locationPharmacy = view.findViewById(R.id.Pharmacy_Location) as TextView
}