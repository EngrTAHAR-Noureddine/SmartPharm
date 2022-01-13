package com.example.smartpharm.firebase.controllers.users


import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.example.smartpharm.firebase.DataBase
import com.example.smartpharm.firebase.models.User


object ClientController {

    var listPharmacies = MutableLiveData<List<User>>()


    fun getListPharmacies(context: FragmentActivity){
        DataBase.db.collection("User")
            .get()
            .addOnSuccessListener { querySnapshot ->run{
                if (!querySnapshot.isEmpty) {
                    var list:List<User>? = querySnapshot.toObjects(User::class.java)
                    listPharmacies.value = list?.filter{ item -> (item.typeUser == "Pharmacy")}
                }
            }
            }
            .addOnFailureListener { exception ->run{
                Log.w("FIRESTORE", "Error getting documents $exception")
                val text = "Out Connexion"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }

            }
    }


}