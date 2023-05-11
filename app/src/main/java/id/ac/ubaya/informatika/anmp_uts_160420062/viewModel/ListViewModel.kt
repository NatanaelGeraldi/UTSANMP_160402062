package id.ac.ubaya.informatika.anmp_uts_160420062.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Kost
import androidx.lifecycle.AndroidViewModel
import com.android.volley.RequestQueue
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Pemilik

class ListViewModel(application: Application): AndroidViewModel(application) {
    val kostsLD = MutableLiveData<ArrayList<Kost>>()
    val kostLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh(){
        kostLoadErrorLD.value = false
        /*val pemilik1 = Pemilik("Sutrisno", "Jl.Milky way no 1 rt2 rw 3",
            "https://upload.wikimedia.org/wikipedia/commons/7/78/Try_Sutrisno_Official_Portrait.jpg")*/
        var json = "[{'blokKos' : 'AN-57','namaKos' :'Kost Putra','alamatKos' : 'Tenggilis Mejoyo AN-57', 'notelKos': '0845345345', 'namaPemilik' : 'Sutrisno', 'photo' : 'https://lh5.googleusercontent.com/p/AF1QipPRGSsKlYuTpLkKiMCbriVTPf_n0lxeI6yBnp74=w216-h218-n-k-no'}," +
                "{'blokKos' : 'AM-12','namaKos' :'Kost Depan Ubaya KK 44','alamatKos' : 'Tenggilis Mejoyo AM-12', 'notelKos': '082188451261', 'namaPemilik' : 'Sumanto', 'photo' : 'https://www.sewakost.com/files/03-2022/ad75866/kost-putri-dekat-ubaya-113875238.jpg'}," +
                "{'blokKos' : 'AN-26','namaKos' :'KOST Putri Ubaya','alamatKos' : 'Tenggilis Mejoyo AN-12', 'notelKos': '08216578453', 'namaPemilik' : 'Sukirman', 'photo' : 'https://lh5.googleusercontent.com/p/AF1QipNsTYDpgfZjaXQH5dWaEdnRZWPgIcmbAMWm-RtN=w408-h544-k-no'}," +
                "{'blokKos' : 'AN-9','namaKos' :'Kost Putri AN-9','alamatKos' : 'Tenggilis Mejoyo AN-9 No 36', 'notelKos': '(031)8436342', 'namaPemilik' : 'Supriman', 'photo' : 'https://www.sewakost.com/files/08-2022/ad92637/kost-1556090935.jpg'}," +
                "{'blokKos' : 'AM-14','namaKos' :'Kost AM-14 UBAYA','alamatKos' : 'Tenggilis Mejoyo AM-14', 'notelKos': '085287878973', 'namaPemilik' : 'Sukijan', 'photo' : 'https://lh5.googleusercontent.com/p/AF1QipOeQIbQkWEsE8WGU4h8iiBAgXvvuuqMWD4KQkaf=w408-h306-k-no'}]"
        //val pemilikList:ArrayList<Pemilik> = arrayListOf<Pemilik>(pemilik1)
        var gson = GsonBuilder().create()
        var result = gson.fromJson<ArrayList<Kost>>(json, object : TypeToken<ArrayList<Kost>>(){}.type)
        kostsLD.value = result
        loadingLD.value = false
    }
}

