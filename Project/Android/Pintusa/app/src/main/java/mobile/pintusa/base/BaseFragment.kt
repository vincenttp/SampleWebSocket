package mobile.pintusa.base

import android.app.ProgressDialog
import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection
import mobile.pintusa.R

open class BaseFragment : Fragment() {
    protected val loading by lazy {
        val dialog = ProgressDialog(activity!!, R.style.LoadingStyle)
        dialog.setProgressStyle(android.R.style.Widget_Material_Light_ProgressBar_Large_Inverse)
        dialog.setCancelable(false)
        dialog
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}