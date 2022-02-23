package com.example.smartpharm.activities
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.smartpharm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("TypeUserFile", Context.MODE_PRIVATE)
        val typeUser = pref.getString("typeUserFile", null)

        Log.d("typeUser", typeUser.toString())

        if (typeUser!=null && typeUser == "Client") {
            intent = Intent(applicationContext, ClientActivity::class.java)
            startActivity(intent)
            finish()
        }else if (typeUser!=null && typeUser == "Pharmacy"){
            intent = Intent(applicationContext, PharmacistActivity::class.java)
            startActivity(intent)
            finish()
        }
        else {
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}