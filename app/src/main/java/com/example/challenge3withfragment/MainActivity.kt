package com.example.challenge3withfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFirstFragmen()
    }

    private fun openFirstFragmen() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val blankFragment = BlankFragment()
        fragmentTransaction.add(
            R.id.container,
            blankFragment,
            BlankFragment::class.java.simpleName
        )
        fragmentTransaction.commit()
        fragmentTransaction.addToBackStack(null)
    }
}