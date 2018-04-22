package mobile.pintusa.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import mobile.pintusa.base.BaseActivity
import mobile.pintusa.home.HomeFragment
import mobile.pintusa.R
import javax.inject.Inject

class Home : BaseActivity(), HasSupportFragmentInjector, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    private val REQUEST_LOCATION_PERMISSION = 10

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            setFragmentInHome(HomeFragment::class.java.simpleName, HomeFragment())
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), REQUEST_LOCATION_PERMISSION)
        }

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            /*R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }*/
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            REQUEST_LOCATION_PERMISSION->{
                if (grantResults.isEmpty()||grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    finish()
                }else{
                    setFragmentInHome(HomeFragment::class.java.simpleName, HomeFragment())
                }
            }
        }
    }

    private fun setFragmentInHome(tagFragment: String, fragmentToShow: Fragment) {
        val transaction = this.supportFragmentManager.beginTransaction()

        var targetFragment: Fragment?
        val tag: String?
        var isNew = false

        tag = tagFragment
        targetFragment = this.supportFragmentManager.findFragmentByTag(tag)
        if (targetFragment == null) {
            targetFragment = fragmentToShow
            isNew = true
        }

        for (fragment in this.supportFragmentManager.fragments) {
            transaction.hide(fragment)
        }
        if (isNew) {
            transaction.add(R.id.container, targetFragment, tag)
        } else {
            transaction.show(targetFragment)
        }
        transaction.addToBackStack(tagFragment)
        transaction.commit()
    }
}
