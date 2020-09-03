package com.guapiston.bairesdev

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.guapiston.bairesdev.ui.buttons.ButtonsFragment
import com.guapiston.bairesdev.ui.github.GithubFragment
import com.guapiston.bairesdev.ui.google.GoogleFragment

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_google)
        lauchGoogleFragment()
    }

    private fun launchButtonsFragment(){
        val fragment = ButtonsFragment.instance
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment,"buttonsFragment").commit()
    }

    private fun launchGithubFragment(){
        val fragment = GithubFragment.instance
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment,"githubFragment").commit()
    }

    fun lauchGoogleFragment(url : String = "https://www.google.com/"){
        val fragment = GoogleFragment.newInstance(url)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment,"googleFragment").commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_buttons -> launchButtonsFragment()
            R.id.nav_github -> launchGithubFragment()
            R.id.nav_google -> lauchGoogleFragment()
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}