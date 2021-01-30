package com.parkir.testapp.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parkir.testapp.R
import com.parkir.testapp.model.ListResep
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_resep.view.*
import kotlinx.android.synthetic.main.item_view_custom.view.*

class AdapterListResep internal constructor(isShammer: Boolean) : RecyclerView.Adapter<AdapterListResep.ViewHolder>(){
    internal var listResep = arrayListOf<ListResep>()
    private var isShammer: Boolean = isShammer

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_resep,parent,false))
    }

    override fun getItemCount(): Int = listResep.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view){
            if(isShammer){
                shimmer_view_list_category.startShimmer()
                shimmer_view_list_image.startShimmer()
            }
            else{
                tv_idresep.text = listResep[position].idCategory
                Picasso.get().load(listResep[position].strCategoryThumb).into(img_resep)
                tv_categori.text = listResep[position].strCategory

                shimmer_view_list_category.stopShimmer()
                shimmer_view_list_image.stopShimmer()

                ll_shammer.visibility = View.GONE
                ll_item.visibility = View.VISIBLE
            }
        }
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)
}