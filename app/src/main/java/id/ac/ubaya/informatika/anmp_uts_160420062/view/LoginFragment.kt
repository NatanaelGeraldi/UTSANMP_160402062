package id.ac.ubaya.informatika.anmp_uts_160420062.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_160420062.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegister.setOnClickListener{
            val action = LoginFragmentDirections.loginToRegist()
            Navigation.findNavController(it).navigate(action)
        }
        btnLogin.setOnClickListener{
            var intent = Intent(activity, KostActivity::class.java)
            startActivity(intent)
        }
    }

}