package com.maxataliyev_01.task1.login
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.maxataliyev_01.task1.R

class LoginInActivity : AppCompatActivity() {
    private lateinit var nawController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_in)
       val navHostFragment=supportFragmentManager
           .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        nawController=navHostFragment.navController
    }


    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Exit ")
        dialog.setMessage("Do you want close?")
        dialog.setCancelable(false)
        dialog.setPositiveButton("Yes"
        ) { _, _ ->
        finish()}
        dialog.setNegativeButton(
            "Cancel"
        ) { _, _ ->  }
        dialog.show()
    }

    }



