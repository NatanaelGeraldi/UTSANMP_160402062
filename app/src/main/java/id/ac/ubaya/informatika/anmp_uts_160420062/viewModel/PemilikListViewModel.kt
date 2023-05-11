package id.ac.ubaya.informatika.anmp_uts_160420062.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Kost
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Pemilik

class PemilikListViewModel(application: Application): AndroidViewModel(application) {
    val pemiliksLD = MutableLiveData<ArrayList<Pemilik>>()
    val pemilikLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh(){
        pemilikLoadErrorLD.value = false
        /*val pemilik1 = Pemilik("Sutrisno", "Jl.Milky way no 1 rt2 rw 3",
            "https://upload.wikimedia.org/wikipedia/commons/7/78/Try_Sutrisno_Official_Portrait.jpg")*/

        var json = "[{'namaPemilik' : 'Sutrisno','alamatPemilik' :'Jl.Milkiy Way','photoPemilik' : 'https://upload.wikimedia.org/wikipedia/commons/7/78/Try_Sutrisno_Official_Portrait.jpg'}," +
                "{'namaPemilik' : 'Sumanto','alamatPemilik' :'Jl.Kesana Kemari','photoPemilik' : 'https://assets.pikiran-rakyat.com/crop/130x35:994x683/x/photo/2022/09/05/2782347069.jpg'}," +
                "{'namaPemilik' : 'Sukirman','alamatPemilik' :'Jl.Kemari Kesana','photoPemilik' : 'https://simpeg.unnes.ac.id/index.php/simpeg_portofolio/load_photo/131570066'}," +
                "{'namaPemilik' : 'Sukirman','alamatPemilik' :'Jl. Jalan Kekota Suranaya','photoPemilik' : 'https://2.bp.blogspot.com/-RUW-12KoPjE/VURnUSBPq9I/AAAAAAAAN5c/oDXG9RDLtPU/w1200-h630-p-k-no-nu/sudirman-supriman-sukijan-benablog-parodi-video-1.jpg'}," +
                "{'namaPemilik' : 'Sukijan','alamatPemilik' :'Jl. Slamet Riady','photoPemilik' : 'https://i1.sndcdn.com/artworks-000113992323-x7qxp7-t500x500.jpg'}]"

        var gson = GsonBuilder().create()
        var result = gson.fromJson<ArrayList<Pemilik>>(json, object : TypeToken<ArrayList<Pemilik>>(){}.type)
        pemiliksLD.value = result
        loadingLD.value = false
    }
}