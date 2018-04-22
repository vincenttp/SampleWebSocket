package mobile.pintusa.auth.daftar

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_daftar.*
import mobile.pintusa.R
import mobile.pintusa.auth.daftar.mahasiswa.DaftarMahasiswa
import mobile.pintusa.auth.daftar.satpam.DaftarSatpam
import mobile.pintusa.base.BaseActivity
import javax.inject.Inject

class Daftar : BaseActivity(), HasSupportFragmentInjector, View.OnClickListener, DaftarContract.DaftarView {
    @Inject
    lateinit var presenter: DaftarPresenter

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        presenter.view = this

        btnMahasiswa.isSelected = true
        setFragmentInHome("mahasiswa", DaftarMahasiswa())

        btnMahasiswa.setOnClickListener(this)
        btnSatpam.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            btnMahasiswa.id->{
                btnMahasiswa.isSelected = true
                btnSatpam.isSelected = false
                setFragmentInHome("mahasiswa", DaftarMahasiswa())
            }
            btnSatpam.id->{
                btnMahasiswa.isSelected = false
                btnSatpam.isSelected = true
                setFragmentInHome("satpam", DaftarSatpam())
            }
            btnBack.id->{
                finish()
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
            transaction.add(R.id.frameContainer, targetFragment, tag)
        } else {
            transaction.show(targetFragment)
        }
        transaction.commit()
    }
}
