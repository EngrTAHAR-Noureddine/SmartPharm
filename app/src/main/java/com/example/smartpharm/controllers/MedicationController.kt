package com.example.smartpharm.controllers

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.example.smartpharm.database.DataBase
import com.example.smartpharm.models.Medication
import com.example.smartpharm.models.User
import java.util.*

object MedicationController {

    var listMedications = MutableLiveData<MutableList<Medication>?>()

    fun getMedicationOf(pharmacy: User?, context:FragmentActivity){
        DataBase.db.collection("Medication")
            .get()
            .addOnSuccessListener { querySnapshot ->run{
                if (!querySnapshot.isEmpty) {
                    var list:MutableList<Medication>? = querySnapshot.toObjects(Medication::class.java)
                    listMedications.value = if(pharmacy!=null) list?.filter{ item -> (item.emailPharmacy == pharmacy.emailUser)} as MutableList<Medication>? else null
                }else{
                    val text = "The Pharmacy hasn't the medications"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, text, duration)
                    toast.show()
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

    fun postMedication(medication: Medication, context: Context){
            DataBase.db.collection("Medication").document(UUID.randomUUID().toString())
                .set(medication)
                .addOnSuccessListener {
                    var list :MutableList<Medication>?  = listMedications.value
                    list?.add(medication)
                    listMedications.value = list

                    Toast.makeText(context, "Success Upload", Toast.LENGTH_SHORT).show() }
                .addOnFailureListener { Toast.makeText(context, "Failed Upload", Toast.LENGTH_SHORT).show()}
    }

    fun deleteMedication(medication: Medication, context: Context){
        DataBase.db.collection("Medication").document(medication.idMedication)
            .delete()
            .addOnSuccessListener {
                Log.d("FIRESTORE", "DocumentSnapshot successfully deleted!")
                Toast.makeText(context, "successfully deleted!", Toast.LENGTH_SHORT).show()
                val list =if(listMedications.value!=null) listMedications.value!!.filter { item: Medication -> item.idMedication!= medication.idMedication}else null
                listMedications.value = list as MutableList<Medication>?
            }
            .addOnFailureListener {  Toast.makeText(context, "Delete Failed!", Toast.LENGTH_SHORT).show() }
    }

    fun searchMedication(word:String?, pharmacy: User?, context:FragmentActivity){
        if(!word.isNullOrEmpty()) {
            val list = listMedications.value?.filter { item: Medication ->
                item.nameMedication.lowercase(Locale.ROOT).contains(word.lowercase(Locale.ROOT))
            }
            listMedications.value = list as MutableList<Medication>?
        }
        else{
            getMedicationOf(pharmacy,context)
        }
    }
}