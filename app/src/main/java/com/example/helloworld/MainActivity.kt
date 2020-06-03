package com.example.helloworld

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private var spinner:Spinner ? = null
    private var arrayAdapter:ArrayAdapter<String> ? = null
    private var fibOptions = generate1thru100()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val fab: FloatingActionButton = findViewById(R.id.fab)

        spinner = findViewById(R.id.fibSelect)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, fibOptions)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener  = object :


            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var fibResult : TextView = findViewById(R.id.fibResult)
                var numSelected = fibOptions[position].toInt()
                fibResult.text = fibCalc(numSelected).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                var fibResult : TextView = findViewById(R.id.fibResult)
                fibResult.text = "0"
            }
        }



        val sixthFib = fibCalc(8)





        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action, the 8th fibonacci number is ".plus(sixthFib.toString()), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun generate1thru100() : Array<String>{

        return Array(100) { i -> (i).toString() }
    }


}