package id.ac.ubaya.informatika.anmp_uts_160420062.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.anmp_uts_160420062.R
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Kost
import id.ac.ubaya.informatika.anmp_uts_160420062.util.loadImage
import kotlinx.android.synthetic.main.fragment_kost.view.*
import kotlinx.android.synthetic.main.fragment_pemilik.view.*

class KostListAdapter (val kostList:ArrayList<Kost>)
    :RecyclerView.Adapter<KostListAdapter.KostViewHolder>(){

    class KostViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_kost, parent, false)
        return KostViewHolder(view)
    }

    override fun onBindViewHolder(holder: KostViewHolder, position: Int) {
        holder.view.txtBlok.text = kostList[position].blokKos
        holder.view.txtNamaKos.text = kostList[position].namaKos
        holder.view.txtAlamat.text = kostList[position].alamatKos
        holder.view.btnCek.setOnClickListener{
            val action = KostListFragmentDirections.kostListToDetail(kostList[position].blokKos.toString(),kostList[position].namaKos.toString(),kostList[position].alamatKos.toString(),
                kostList[position].notelKos.toString(),kostList[position].namaPemilik.toString(),kostList[position].photo.toString())
            Navigation.findNavController(it).navigate(action)
        }
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(kostList[position].photo, progressBar)
    }

    override fun getItemCount(): Int {
        return kostList.size
    }
    fun updateKostList(newKostList: ArrayList<Kost>) {
        kostList.clear()
        kostList.addAll(newKostList)
        notifyDataSetChanged()
    }
}