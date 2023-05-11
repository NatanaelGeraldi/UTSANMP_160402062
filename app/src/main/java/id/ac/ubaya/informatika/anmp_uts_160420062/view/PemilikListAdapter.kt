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
import id.ac.ubaya.informatika.anmp_uts_160420062.model.Pemilik
import id.ac.ubaya.informatika.anmp_uts_160420062.util.loadImage
import kotlinx.android.synthetic.main.fragment_kost.view.*
import kotlinx.android.synthetic.main.fragment_kost.view.txtAlamat
import kotlinx.android.synthetic.main.fragment_kost_detail.view.*
import kotlinx.android.synthetic.main.fragment_pemilik.view.*
import kotlinx.android.synthetic.main.fragment_pemilik_detail.view.*

class PemilikListAdapter (val pemilikList:ArrayList<Pemilik>)
    : RecyclerView.Adapter<PemilikListAdapter.PemilikViewHolder>() {

    class PemilikViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PemilikViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_pemilik, parent, false)
        return PemilikViewHolder(view)
    }

    override fun onBindViewHolder(holder: PemilikViewHolder, position: Int) {
        holder.view.txtNamaPemilikList.text = pemilikList[position].namaPemilik
        holder.view.txtAlamatPemilikList.text = pemilikList[position].alamatPemilik
        holder.view.btnLihat.setOnClickListener{
            val action = PemilikListFragmentDirections.pemilikListToDetailPemilik(pemilikList[position].namaPemilik.toString(),pemilikList[position].alamatPemilik.toString(),
                pemilikList[position].photoPemilik.toString())
            Navigation.findNavController(it).navigate(action)
        }
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(pemilikList[position].photoPemilik, progressBar)


    }

    override fun getItemCount(): Int {
        return pemilikList.size
    }
    fun updatePemilikList(newPemilikList: ArrayList<Pemilik>) {
        pemilikList.clear()
        pemilikList.addAll(newPemilikList)
        notifyDataSetChanged()
    }


}
