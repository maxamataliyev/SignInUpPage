package com.maxataliyev_01.task1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class LoginInActivity : AppCompatActivity() {
    private lateinit var nawController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_in)
       val navHostFragment=supportFragmentManager
           .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        nawController=navHostFragment.navController
    }


//    override fun onBackPressed() {
//        super.onBackPressed()
//        AlertDialog.Builder(this)
//            .setTitle("Exit")
//            .setMessage("Are you sure want to exit?")
//            .setIcon(R.drawable.ic_warning)
//            .setCancelable(false)
//            .setPositiveButton("Yes") { _, _ -> finish() }
//            .setNegativeButton("No",null) .show()
//
//       }
    }
