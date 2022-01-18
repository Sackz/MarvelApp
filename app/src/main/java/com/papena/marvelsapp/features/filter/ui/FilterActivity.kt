package com.papena.marvelsapp.features.filter.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.papena.marvelsapp.R
import com.papena.marvelsapp.components.MarvelToolbar
import com.papena.marvelsapp.components.MarvelToolbarType
import com.papena.marvelsapp.features.filter.viewmodel.FilterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterActivity: AppCompatActivity() {

    private var toolbar : MarvelToolbar? = null
    private var navHostFragment: NavHostFragment? = null
    var navController: NavController? = null

    val filterViewModel: FilterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val nav = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (nav != null) {
            navHostFragment = nav as NavHostFragment
            navController = navHostFragment?.navController
        }

        toolbar = findViewById(R.id.toolbar)

        toolbar?.let {
            it.initToolbar(MarvelToolbarType.DETAIL){
                onBackPressed()
            }
        }

        toolbar?.setToolbarTitle("Filtros")
    }
}