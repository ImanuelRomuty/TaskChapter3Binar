package com.example.challenge3withfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*


class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val patchName = arguments?.getString("nama")
        val patchName2 = arguments?.getString("nama2")
        val patchAge = arguments?.getString("usia")
        val patchAddress = arguments?.getString("alamat")
        val patchJob = arguments?.getString("pekerjaan")


//        DEBUG
        Log.d("SEC NEW USIA : ", patchAge.toString())
        Log.d("SEC NEW ALAMAT : ", patchAddress.toString())
        Log.d("SEC NEW PEKERJAAN  : ", patchJob.toString())

        temp_text_view.text = patchName

        val ageTemp = patchAge?.toInt()
        val tempString : String
        if (ageTemp!=null){
            tempString = if (ageTemp%2==0){
                "$patchAge, Bernilai Genap"
            }else {
                "$patchAge, Bernilai Ganjil"
            }
            temp_text_view.text ="""
                $patchName2
                $tempString
                $patchAddress
                $patchJob
            """.trimIndent()
            }
        navigate_to_third_fragment_button.setOnClickListener {
            val fragmentManager : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
            val thirdFragment = ThirdFragment()
            val bundle = Bundle()
            bundle.putString("nama",patchName)
            thirdFragment.arguments = bundle
            fragmentTransaction.replace(R.id.container,thirdFragment, ThirdFragment::class.java.simpleName)
            fragmentTransaction.commit()
            fragmentTransaction.addToBackStack(null)
        }
        }
    }
