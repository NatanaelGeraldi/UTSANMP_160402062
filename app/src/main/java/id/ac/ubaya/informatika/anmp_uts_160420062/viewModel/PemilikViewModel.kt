package id.ac.ubaya.informatika.anmp_uts_160420062.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Pemilik

class PemilikViewModel: ViewModel() {
    val pemilikLD = MutableLiveData<Pemilik>()
    fun fetch(namaPemilik:String, alamatPemilik:String,photo:String){
        val pemilikData = Pemilik(namaPemilik,alamatPemilik,photo)
        pemilikLD.value= pemilikData
    }
}