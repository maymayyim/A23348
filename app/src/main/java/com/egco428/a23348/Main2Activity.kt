package com.egco428.a23348

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    var rand = 0
    var numbers = arrayOfNulls<Int>(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.setTitle("Lucky Draw Result")

        val extras = intent.extras
        rand = extras.getInt("rand")
        rando.text = rand.toString()
        randomNum()

        button2.setOnClickListener {
            finish()
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun randomNum(){
        var str: String = ""
        for (i in 0..4) {
            numbers[i] = Random().nextInt(20) + 20
            if(i == 0)
                str = numbers[i].toString()
            else
                str = str + ", " +numbers[i].toString()

            if(numbers[i] == rand){
                result.text = "You Win !!!"
                imageView2.setImageResource(R.drawable.win)
            }
        }
        resultRand.text = str

    }
}
