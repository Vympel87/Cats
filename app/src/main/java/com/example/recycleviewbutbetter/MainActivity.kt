package com.example.recycleviewbutbetter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecycleview : RecyclerView
    private lateinit var newArrayList: ArrayList<Cats>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.anggora,
            R.drawable.domestik,
            R.drawable.maine_coon,
            R.drawable.persia,
            R.drawable.ragdoll,
            R.drawable.russian_blue,
            R.drawable.siam,
            R.drawable.sphynx
        )

        heading = resources.getStringArray(R.array.description)

        newRecycleview = findViewById(R.id.recycleview)
        newRecycleview.layoutManager = LinearLayoutManager(this)
        newRecycleview.setHasFixedSize(true)

        newArrayList = arrayListOf<Cats>()
        getUserdata()
    }

    private fun getUserdata() {

        for(i in imageId.indices) {
            val cats = Cats(imageId[i], heading[i])
            newArrayList.add(cats)
        }

        newRecycleview.adapter = CatsAdapter(newArrayList)
    }
}