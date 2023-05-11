package id.ac.ubaya.informatika.anmp_uts_160420062.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_160420062.R
import id.ac.ubaya.informatika.anmp_uts_160420062.viewModel.DetailViewModel
import id.ac.ubaya.informatika.anmp_uts_160420062.viewModel.PemilikViewModel
import kotlinx.android.synthetic.main.fragment_kost_detail.*


class PemilikDetailFragment : Fragment() {
    private lateinit var viewModel: PemilikViewModel

    var nama = ""
    var alamat = ""
    var photo = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pemilik_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            nama = PemilikDetailFragmentArgs.fromBundle(requireArguments()).nama
            alamat = PemilikDetailFragmentArgs.fromBundle(requireArguments()).alamat
            photo = PemilikDetailFragmentArgs.fromBundle(requireArguments()).photo
        }
        viewModel = ViewModelProvider(this).get(PemilikViewModel::class.java)
        viewModel.fetch(nama,alamat,photo)
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.pemilikLD.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextView>(R.id.txtNamaPemilikDetail)?.setText(it.namaPemilik)
            view?.findViewById<TextView>(R.id.txtAlamatPemilikDetail)?.setText(it.alamatPemilik)
            Picasso.get().load(it.photoPemilik.toString()).into(imgDetail)
        })
    }
}