package com.example.helloworld

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.helloworld.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        val sixthFib = FibCalc(6)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action, the 6th fibonacci number is ".plus(sixthFib.toString()), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun FibCalc(numberToGo: Int): Int{
        if(numberToGo == 0){
            return 0
        }
        else if(numberToGo == 1){
            return 1
        }
        return FibCalcRecurse(numberToGo -2 , 0,1)
    }

    fun FibCalcRecurse(stepsLeft: Int, prevNum: Int, currNum: Int): Int{
        if(stepsLeft == 0) return  currNum
        val nextNum = prevNum + currNum
        return FibCalcRecurse(stepsLeft -1, currNum, nextNum)
    }
}