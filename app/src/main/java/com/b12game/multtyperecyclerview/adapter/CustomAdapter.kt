package com.b12game.multtyperecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.b12game.multtyperecyclerview.R
import com.b12game.multtyperecyclerview.model.Member
import org.w3c.dom.Text

class CustomAdapter (var members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TYPE_AVAILABLE_YES = 0
    private val TYPE_AVAILABLE_NOT = 1

    override fun getItemViewType(position: Int): Int {
        return if(members[position].available){
            TYPE_AVAILABLE_YES
        }else
            TYPE_AVAILABLE_NOT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_AVAILABLE_YES){
            val viwe = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_yes,parent,false)
            return CustomViewYesHolder(viwe)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_not,parent,false)
        return CustomViewNotHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var member = members.get(position)
        if(holder is CustomViewYesHolder){
            holder.first_name.setText(member.firstName)
            holder.last_name.setText(member.lastName)
        }
        if(holder is CustomViewNotHolder){
            holder.first_name.setText("This first name is not available")
            holder.last_name.setText("This last name is not available")
        }

    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomViewYesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var first_name = itemView.findViewById<TextView>(R.id.tv_first_name)
        var last_name = itemView.findViewById<TextView>(R.id.tv_last_name)
    }

    class CustomViewNotHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var first_name = itemView.findViewById<TextView>(R.id.tv_first_name)
        var last_name = itemView.findViewById<TextView>(R.id.tv_last_name)
    }
}