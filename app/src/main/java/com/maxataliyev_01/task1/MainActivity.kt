package com.maxataliyev_01.task1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.maxataliyev_01.task1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val homeFragment=HomeFragment()
        val productFragment=ProductsFragment()
        val favoriteFragment=FavoriteFragment()
        val profileFragment=ProfileFragment()
        setCurrentFragment(homeFragment)
        binding.bottomNavigationMenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome->setCurrentFragment(homeFragment)
                R.id.miProducts->setCurrentFragment(productFragment)
                R.id.miFavorites->setCurrentFragment(favoriteFragment)
                R.id.miProfile->setCurrentFragment(profileFragment)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }
