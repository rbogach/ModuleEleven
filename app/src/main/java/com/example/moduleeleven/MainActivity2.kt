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
import com.example.moduleeleven.databinding.ActivityMain2Binding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {

    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
val binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)

        drawer = binding.root
        navDrawer = binding.navView

        setupToolBar()
        setupDrawer()

        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        //if(intent?.extras?.isEmpty == false){
            //val name = intent.getStringExtra("name")
         //   val age = intent.getIntExtra("age", 0)
       // }

        //val result = Intent()
        //result.putExtra("result","Navegacao com intents")
       // setResult(Activity.RESULT_OK, result)
        //finish()
    }

    private fun setupDrawer(){
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

    override fun onNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
    }
}