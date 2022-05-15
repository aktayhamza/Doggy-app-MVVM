package com.hamzaaktay.dogappmvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.hamzaaktay.dogappmvvm.R
import com.hamzaaktay.dogappmvvm.databinding.ActivityMainBinding
import com.hamzaaktay.dogappmvvm.utils.extensions.closeCheckable
import com.hamzaaktay.dogappmvvm.utils.extensions.openCheckable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        with(binding.bottomNavigationView) {
            closeCheckable()
            background = null
            menu.get(1).isEnabled = false
            //itemIconTintList = false
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.homeFragment3 || destination.id == R.id.bookmarkFragment2) {
                with(binding.bottomNavigationView) {
                    openCheckable()
                }
            }

        }

        binding.fab.setOnClickListener {
            binding.bottomNavigationView.closeCheckable()
            navHostFragment.navController.navigate(R.id.toDogFragment)
        }
    }




    }

