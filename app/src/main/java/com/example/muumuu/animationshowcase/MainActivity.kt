package com.example.muumuu.animationshowcase

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import com.example.muumuu.animationshowcase.extension.replace
import com.example.muumuu.animationshowcase.extension.show
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show(Samples.values().first())
        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        show(Samples.values().first { it.id == item.itemId })
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun show(sample: Samples) {
        supportFragmentManager.run {
            val fragment = findFragmentByTag(sample.name)
            if (fragment == null) {
                show(R.id.container, sample.newFragment(), sample.name)
            } else {
                replace(R.id.container, fragment, sample.name)
            }
        }
        toolbar.title = sample.name
    }
}