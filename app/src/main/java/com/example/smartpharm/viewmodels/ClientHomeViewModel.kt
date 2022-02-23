package com.example.smartpharm.viewmodels

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.example.smartpharm.databinding.ClientHomeFragmentBinding
import com.example.smartpharm.controllers.UserController.getPharmacies
import com.example.smartpharm.controllers.ClientController

class ClientHomeViewModel( private val binding: ClientHomeFragmentBinding
                          , private val context : FragmentActivity) : ViewModel() {

    var pharmacies = ClientController.listPharmacies

    init {
        initializeListPharmacies()
    }

    private fun initializeListPharmacies() {
        getPharmacies(context)
    }



}