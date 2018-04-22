package mobile.pintusa.auth.daftar.mahasiswa


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_daftar_mahasiswa.*

import mobile.pintusa.R
import mobile.pintusa.auth.daftar.Daftar
import mobile.pintusa.base.BaseFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class DaftarMahasiswa : BaseFragment(), DaftarMahasiswaContract.DaftarMahasiswaView {
    @Inject
    lateinit var presenter: DaftarMahasiswaPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_mahasiswa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.activity = activity as Daftar

        btnDaftar.setOnClickListener {
            presenter.daftar(
                    nama.text.toString(),
                    nim.text.toString(),
                    jurusan.text.toString(),
                    email.text.toString(),
                    password.text.toString()
            )
        }
    }
}
