package com.nuruysal.harrypoterdemo

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.nuruysal.harrypoterdemo.R.*
import com.nuruysal.harrypoterdemo.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by serifenuruysal on 8/1/21.
 */

@AndroidEntryPoint
class MainActivity : BaseActivity(
    layoutId = layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //integration of navigation controller with toolbar
        val navHostFragment =
            supportFragmentManager.findFragmentById(id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)
    }

}