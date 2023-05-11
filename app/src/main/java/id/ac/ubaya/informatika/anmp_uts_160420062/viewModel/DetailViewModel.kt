package id.ac.ubaya.informatika.anmp_uts_160420062.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Kost

class DetailViewModel:ViewModel() {
    val kostLD = MutableLiveData<Kost>()
    fun fetch(blokkos:String, namaKos:String, alamatKos:String,notelKos:String,namaPemilik:String,photo:String){
        val kostData = Kost(blokkos,namaKos,alamatKos,notelKos, namaPemilik ,photo)
        kostLD.value=kostData
    }
}