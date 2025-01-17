package com.example.cprogramming.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cprogramming.Model
import com.example.cprogramming.MyAdapter
import com.example.cprogramming.R

class Home : Fragment()
{
  lateinit var recycler: RecyclerView
    lateinit var list: MutableList<Model>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
     var view = inflater.inflate(R.layout.fragment_home, container, false)

        recycler=view.findViewById(R.id.recycler)

        list=ArrayList()

        var layout:RecyclerView.LayoutManager=GridLayoutManager(activity,2)
        recycler.layoutManager=layout

        list.add(Model(R.drawable.c,"Tutorial"))
        list.add(Model(R.drawable.img,"Programs"))
        list.add(Model(R.drawable.job,"Q/A about C Language"))
        list.add(Model(R.drawable.int2,"Interview Q/A"))
        list.add(Model(R.drawable.pattern,"Pattern"))
        list.add(Model(R.drawable.quiz,"Quiz"))


        var myAdapter=MyAdapter(requireActivity(),list)
        recycler.adapter=myAdapter

    return view
    }


}