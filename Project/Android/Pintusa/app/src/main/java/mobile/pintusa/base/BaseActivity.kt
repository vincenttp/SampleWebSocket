package mobile.pintusa.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import mobile.pintusa.R

open class BaseActivity: AppCompatActivity() {
    val loading by lazy {
        val dialog = ProgressDialog(this, R.style.LoadingStyle)
        dialog.setProgressStyle(android.R.style.Widget_Material_Light_ProgressBar_Large_Inverse)
        dialog.setCancelable(false)
        dialog
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }
}