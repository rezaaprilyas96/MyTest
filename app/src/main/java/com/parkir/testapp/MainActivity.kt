package com.parkir.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.parkir.testapp.utils.intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        cv_costom_view.setOnClickListener(this)
        cv_list_resep.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            cv_costom_view ->{
                intent<CustomView>()
            }
            cv_list_resep ->{
                intent<ListResetActivity>()
            }
        }
    }
}