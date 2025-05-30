package com.example.rawmixapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

abstract class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setItemIconTintList(null)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
        
        // Set the current menu item based on the activity
        setCurrentMenuItem()
    }

    private fun setCurrentMenuItem() {
        val menuItemId = when (this) {
            is MainActivity -> R.id.nav_home
            is Page1Activity -> R.id.nav_materials_lsf_am
            is Page2Activity -> R.id.nav_recipe_lsf_am
            is Page3Activity -> R.id.nav_materials_lsf_sm
            is Page4Activity -> R.id.nav_recipe_lsf_sm
            is Page5Activity -> R.id.nav_materials_lsf_sm_am
            is Page6Activity -> R.id.nav_recipe_lsf_sm_am
            is Page7Activity -> R.id.nav_fuel_and_clinker_factor
            is Page8Activity -> R.id.nav_raw_mix_design
            is Page9Activity -> R.id.nav_graph
            is Page10Activity -> R.id.nav_previous_information_data_list
            else -> null
        }
        
        menuItemId?.let {
            navigationView.menu.findItem(it)?.isChecked = true
        }
    }

    protected fun setActivityContent(layoutResID: Int) {
        val contentFrame: FrameLayout = findViewById(R.id.content_frame)
        // Clear previous content before inflating new layout
        contentFrame.removeAllViews()
        layoutInflater.inflate(layoutResID, contentFrame, true)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Don't navigate if the selected item is already the current activity
        if (item.isChecked) {
            drawerLayout.closeDrawer(GravityCompat.START)
            return true
        }

        var intent: Intent? = null
        when (item.itemId) {
            R.id.nav_home -> {
                if (this !is MainActivity) {
                    intent = Intent(this, MainActivity::class.java)
                }
            }
            R.id.nav_materials_lsf_am -> {
                if (this !is Page1Activity) {
                    intent = Intent(this, Page1Activity::class.java)
                }
            }
            R.id.nav_recipe_lsf_am -> {
                if (this !is Page2Activity) {
                    intent = Intent(this, Page2Activity::class.java)
                }
            }
            R.id.nav_materials_lsf_sm -> {
                if (this !is Page3Activity) {
                    intent = Intent(this, Page3Activity::class.java)
                }
            }
            R.id.nav_recipe_lsf_sm -> {
                if (this !is Page4Activity) {
                    intent = Intent(this, Page4Activity::class.java)
                }
            }
            R.id.nav_materials_lsf_sm_am -> {
                if (this !is Page5Activity) {
                    intent = Intent(this, Page5Activity::class.java)
                }
            }
            R.id.nav_recipe_lsf_sm_am -> {
                if (this !is Page6Activity) {
                    intent = Intent(this, Page6Activity::class.java)
                }
            }
            R.id.nav_fuel_and_clinker_factor -> {
                if (this !is Page7Activity) {
                    intent = Intent(this, Page7Activity::class.java)
                }
            }
            R.id.nav_raw_mix_design -> {
                if (this !is Page8Activity) {
                    intent = Intent(this, Page8Activity::class.java)
                }
            }
            R.id.nav_graph -> {
                if (this !is Page9Activity) {
                    intent = Intent(this, Page9Activity::class.java)
                }
            }
            R.id.nav_previous_information_data_list -> {
                if (this !is Page10Activity) {
                    intent = Intent(this, Page10Activity::class.java)
                }
            }
        }

        if (intent != null) {
            // Clear top to avoid multiple instances of the same activity
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            finish() // Close the current activity
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}