package com.arrow.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentOneTag = "Fragment One"
    private val fragmentOne = FragmentOne()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add "FragmentOne" to container (Main Activity)
        // provide tag name to handle configuration changes
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, fragmentOne, fragmentOneTag)
                    .commit()
        }

        // add fragment button on-click listener
        buttonAddFragment.setOnClickListener {
            if (!fragmentOne.isAdded) {
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.container, fragmentOne, fragmentOneTag)
                        .commit()
            }
        }

        // remove fragment button on-click listener
        buttonRemoveFragment.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .remove(fragmentOne)
                    .commit()
        }
    }
}