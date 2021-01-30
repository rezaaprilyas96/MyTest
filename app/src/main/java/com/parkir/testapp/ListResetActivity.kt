package com.parkir.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.hitungcepat.network.ApiClient
import com.parkir.testapp.adaptor.AdapterListResep
import com.parkir.testapp.model.ListResep
import com.parkir.testapp.model.categori
import com.parkir.testapp.utils.toast
import kotlinx.android.synthetic.main.activity_list_reset.*
import kotlinx.android.synthetic.main.item_resep.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ListResetActivity : AppCompatActivity() {
    //data list resep
    private lateinit var adapterListResep: AdapterListResep
    private var listResep = arrayListOf<ListResep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_reset)

        init()
    }

    private fun init(){
        //adapter
        adapterListResep = AdapterListResep(true)
        adapterListResep.notifyDataSetChanged()
        rv_list_resep.setHasFixedSize(true)
        rv_list_resep.setItemViewCacheSize(20)
        rv_list_resep.layoutManager = LinearLayoutManager(applicationContext)

        addShammer()
    }

    private fun addShammer(){
        listResep.clear()
        for (i in 0..6){
            val adapterList = ListResep("","","","")
            listResep.add(adapterList)
        }

        listRecy()

        Timer().schedule(object : TimerTask() {
            override fun run() {
                addItemResep()
            }
        }, 1000)
    }

    private fun addItemResep() {
        listResep.clear()

        ApiClient.getService()?.getListResep()?.enqueue(object : Callback<categori> {
            override fun onFailure(call: Call<categori>, t: Throwable) {
                listResep.clear()
                for (i in 0..6){
                    val adapterList = ListResep("","","","")
                    listResep.add(adapterList)
                }

                listRecy()
                toast(t.localizedMessage)
            }

            override fun onResponse(call: Call<categori>, response: Response<categori>) {
                if(!response.isSuccessful){
                    toast(response.code().toString())
                    return
                }

                val items = response.body()!!.categori
                for ( (id ,categori, gambar, deskripsi) in items!!) {
                    val adapterList = ListResep(id, categori, gambar,deskripsi)
                    listResep.add(adapterList)
                }

                adapterListResep = AdapterListResep(false)

                listRecy()
            }
        })
    }

    private fun listRecy(){
        Collections.reverse(listResep)
        adapterListResep.listResep = listResep
        rv_list_resep.adapter = adapterListResep
    }
}
