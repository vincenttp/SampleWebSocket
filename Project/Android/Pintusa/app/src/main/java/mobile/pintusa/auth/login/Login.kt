package mobile.pintusa.auth.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import mobile.pintusa.R
import mobile.pintusa.main.Home
import mobile.pintusa.auth.daftar.Daftar
import mobile.pintusa.base.BaseActivity
import javax.inject.Inject

class Login : BaseActivity(), View.OnClickListener, LoginContract.LoginView {
    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.view = this
        presenter.activity = this

        btnDaftar.setOnClickListener(this)
        btnMasuk.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            btnDaftar.id->{
                startActivity(Intent(this, Daftar::class.java))
            }
            btnMasuk.id->{
                presenter.login(username.text.toString(), password.text.toString())
            }
        }
    }
}
