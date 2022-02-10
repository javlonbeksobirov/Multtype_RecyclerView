package com.b12game.multtyperecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b12game.multtyperecyclerview.adapter.CustomAdapter
import com.b12game.multtyperecyclerview.model.Member

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)
    }

    fun refreshAdapter(members: List<Member>){
        val adapter = CustomAdapter(members)
        recyclerView!!.adapter = adapter
    }

    fun prepareMemberList():List<Member>{
        val members = ArrayList<Member>()
        for(i in 0..20){
            if(i == 1 || i == 4 || i == 12 || i == 16 || i == 20){
                members.add(Member("Javlonbek " + i,"Sobirov " + 1, false))
            }else
                members.add(Member("Sobirov " + i,"Sardor " + i, true))
        }
        return members
    }
}