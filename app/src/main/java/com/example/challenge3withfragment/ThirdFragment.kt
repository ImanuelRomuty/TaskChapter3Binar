package com.example.challenge3withfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_third.*
class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val patchName = arguments?.getString("nama")
        navigate_back_to_third_fragment_button.setOnClickListener {
            val fragmentManager : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
            val backSecondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putString("nama2",patchName)
            bundle.putString("usia",et_usia.text.toString())
            bundle.putString("alamat",et_alamat.text.toString())
            bundle.putString("pekerjaan",et_pekerjaan.text.toString())
            Log.d("THIRD USIA : ", et_usia.text.toString())
            Log.d("THIRD USIA : ", et_alamat.text.toString())
            Log.d("THIRD USIA : ", et_pekerjaan.text.toString())

            backSecondFragment.arguments=bundle
            fragmentTransaction.replace(R.id.container , backSecondFragment )
            fragmentTransaction.commit()
            fragmentTransaction.addToBackStack(null)
        }
    }

}