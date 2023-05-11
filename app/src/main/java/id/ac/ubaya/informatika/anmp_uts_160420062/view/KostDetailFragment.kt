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
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.anmp_uts_160420062.viewModel.DetailViewModel
import id.ac.ubaya.informatika.anmp_uts_160420062.R
import kotlinx.android.synthetic.main.fragment_kost_detail.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_pemilik.*


class KostDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    var blok= ""
    var nama = ""
    var alamat = ""
    var notel = ""
    var pemilik= ""
    var photo = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kost_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            blok = KostDetailFragmentArgs.fromBundle(requireArguments()).blok
            nama = KostDetailFragmentArgs.fromBundle(requireArguments()).nama
            alamat = KostDetailFragmentArgs.fromBundle(requireArguments()).alamat
            notel = KostDetailFragmentArgs.fromBundle(requireArguments()).notel
            pemilik = KostDetailFragmentArgs.fromBundle(requireArguments()).namaPemilik
            photo = KostDetailFragmentArgs.fromBundle(requireArguments()).gambar
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(blok,nama,alamat,notel,pemilik,photo)
        observeViewModel()

        btnPemilik.setOnClickListener{
            val action = KostDetailFragmentDirections.detailKostToPemilikList()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observeViewModel(){
        viewModel.kostLD.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextView>(R.id.txtBlokKos)?.setText(it.blokKos)
            view?.findViewById<TextView>(R.id.txtNamaKos)?.setText(it.namaKos)
            view?.findViewById<TextView>(R.id.txtAlamat)?.setText(it.alamatKos)
            view?.findViewById<TextView>(R.id.txtNoTel)?.setText(it.notelKos)
            view?.findViewById<TextView>(R.id.txtNamaPemilik)?.setText(it.namaPemilik)
            Log.e("observeViewModel: ", it.blokKos.toString() )
            Log.e("observeViewModel: ", it.photo.toString() )
            Picasso.get().load(it.photo.toString()).into(imgDetail)
            })
    }
}