package com.example.moduleeleven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moduleeleven.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

val binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)


        val navHomeFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav
        navController = navHomeFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.playerFragment, R.id.resultFragment), drawer)
        navController.addOnDestinationChangedListener{
            _, destination, _->
            when(destination.id){
                R.id.homeFragment ->bottomNav.visibility = View.GONE
                else -> bottomNav.visibility = View.VISIBLE
            }
        }

        setupActionBarWithNavController(navController,appBarConfiguration)
        navDrawer.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)


        //setupBottomNavigation()


    }

   /* private fun setupBottomNavigation(){
        bottomNav.setOnItemSelectedListener {
            menuItem -> when(menuItem.itemId){
                R.id.playerFragment ->{
                    Snackbar.make(drawer, getString(R.string.bottom_nav_title_1), Snackbar.LENGTH_SHORT).show()
                    true}
                R.id.resultFragment ->{
                    Snackbar.make(drawer, getString(R.string.bottom_nav_title_2), Snackbar.LENGTH_SHORT).show()
                    true }
            else -> false
            }

        }
    }*/


    /*private fun setupDrawer(){
            navDrawer.setNavigationItemSelectedListener { menuItem ->
                drawer.closeDrawers()
                when(menuItem.itemId){
                    R.id.drawer_home ->{
                        onBackPressed()
                        //val intent = Intent(this, MainActivity2::class.java)
                        //startActivity(intent)
                        true
                    }
                    else -> false
                }

            }
    }

    private fun setupToolBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }
*/
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
    }


   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu, menu)
        return true
    }
*/
/*    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_save ->{
                Snackbar.make(this,
                    drawer,
                    getString(R.string.menu_save_title),
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
            R.id.menu_settings ->{
                Snackbar.make(this,
                drawer,
                getString(R.string.menu_settings_title),
                Snackbar.LENGTH_SHORT
                ).show()

                true
            }
            else -> false
        }
    }*/
}