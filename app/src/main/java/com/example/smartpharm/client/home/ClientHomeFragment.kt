package com.example.smartpharm.client.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.smartpharm.R
import com.example.smartpharm.database.smartDataBase
import com.example.smartpharm.databinding.ClientHomeFragmentBinding


class ClientHomeFragment : Fragment() {

    private lateinit var binding: ClientHomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.client_home_fragment,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = smartDataBase.getInstance(application)?.UsersDao()!!
        val viewModelFactory = ClientHomeViewModelFactory(dataSource, binding ,this.requireActivity())
        val clientHomeViewModel = ViewModelProvider(this, viewModelFactory)[ClientHomeViewModel::class.java]
        binding.clientHomeViewModel = clientHomeViewModel
        binding.lifecycleOwner = this



        return binding.root
    }



}