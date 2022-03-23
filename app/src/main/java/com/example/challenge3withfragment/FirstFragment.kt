package com.example.challenge3withfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigate_to_second_fragment_button.setOnClickListener {
            val fragmentManager : FragmentManager = parentFragmentManager
            val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
            val secondFragment = SecondFragment()
            val inputName = input_name_edit_text.text.toString()
            val bundle = Bundle()
            bundle.putString("nama",inputName)
            secondFragment.arguments=bundle


            Log.d("FIRS FRAGMENT NAMA : ",inputName)
            fragmentTransaction.replace(R.id.container,secondFragment, SecondFragment::class.java.simpleName)
            fragmentTransaction.commit()
            fragmentTransaction.addToBackStack(null)

        }

    }

}