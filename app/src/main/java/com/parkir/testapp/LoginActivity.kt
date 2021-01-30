package com.parkir.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.parkir.testapp.utils.intentfinish
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.bottom_sheet_signup.*
import java.util.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    //bottomsheet
    private lateinit var bottomSheetSignup: BottomSheetBehavior<LinearLayout>

    //backPress
    private var klik: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init(){
        //bottomsheet
        bottomSheetSignup = BottomSheetBehavior.from(bottom_sheet_signup)

        tv_signup.setOnClickListener(this)
        rv_signin.setOnClickListener(this)
        rv_signup.setOnClickListener(this)
    }

    override fun onBackPressed() {
        when {
            bottomSheetSignup.state == BottomSheetBehavior.STATE_EXPANDED -> {
                bottomSheetSignup.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            else -> {
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        klik = 0
                    }
                }, 2000)
                klik += 1
                if (klik >= 2) {
                    super.onBackPressed()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "klik sekali lagi untuk keluar",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v){
            tv_signup ->{
                bottomSheetSignup.state = BottomSheetBehavior.STATE_EXPANDED
            }
            rv_signin ->{
                rv_signin.setBackgroundResource(R.drawable.background_btn_disabled)
                rv_signin.isEnabled = true
                intentfinish<MainActivity>()
            }
            rv_signup ->{
                rv_signup.setBackgroundResource(R.drawable.background_btn_disabled)
                intentfinish<MainActivity>()
            }
        }
    }
}