package com.example.smartpharm.order_detail

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smartpharm.databinding.OderDetailFragmentBinding
import com.example.smartpharm.firebase.models.Order

class OrderDetailFactory(private val binding: OderDetailFragmentBinding,
                         private val context: FragmentActivity,
                         private val type : String,
                         private val order : Order? ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OderDetailViewModel::class.java)) {
            return OderDetailViewModel(binding ,context,type,order ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}