package com.example.smartpharm.medications_pharmacy

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smartpharm.databinding.MedicationsListFragmentBinding
import com.example.smartpharm.firebase.models.User

class MedicationsListViewModelFactory(private val user:User?,
                                      private val binding: MedicationsListFragmentBinding,
                                      private val context:FragmentActivity):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicationsListViewModel::class.java)) {
            return MedicationsListViewModel(user, binding ,context ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}