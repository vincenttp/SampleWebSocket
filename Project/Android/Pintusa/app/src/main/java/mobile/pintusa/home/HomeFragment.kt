package mobile.pintusa.home


import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.OnSuccessListener
import mobile.pintusa.R
import mobile.pintusa.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment(), OnMapReadyCallback, OnSuccessListener<Location>, HomeFragmentContract.HomeFragmentView {
    lateinit var googleMap: GoogleMap
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var myPosition: LatLng

    @Inject
    lateinit var presenter: HomeFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fragmetn, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this

        val supportMapFragment: SupportMapFragment = SupportMapFragment.newInstance()
        supportMapFragment.getMapAsync(this)
        childFragmentManager.beginTransaction().replace(R.id.map, supportMapFragment).commit()

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity!!)
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(p0: GoogleMap?) {
        this.googleMap = p0!!
        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this)
        p0.isMyLocationEnabled = true
    }

    override fun onSuccess(p0: Location?) {
        if (p0!=null){
            myPosition = LatLng(p0.latitude, p0.longitude)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 15F))
        }
    }
}
