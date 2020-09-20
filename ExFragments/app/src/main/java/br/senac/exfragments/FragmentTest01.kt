package br.senac.exfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_test01.*
import kotlinx.android.synthetic.main.fragment_test01.view.*


class FragmentTest01 : Fragment() {


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val view = inflater.inflate(R.layout.fragment_test01, container, false)

        view.btnShowMsgFrag01.setOnClickListener {
            Toast.makeText(activity, "Olá,  ${etNameFragment01.text}", Toast.LENGTH_LONG).show()
        }



        return view
    }


}