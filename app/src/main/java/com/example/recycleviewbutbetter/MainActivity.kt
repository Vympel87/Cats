package com.example.recycleviewbutbetter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecycleview : RecyclerView
    private lateinit var newArrayList: ArrayList<Cats>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var cats: Array<String>

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

        heading = resources.getStringArray(R.array.title)

        cats = resources.getStringArray(R.array.body)

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

        var adapter = CatsAdapter(newArrayList)
        newRecycleview.adapter = adapter
        adapter.setOnItemClickListener(object : CatsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

//          Toast.makeText(this@MainActivity, "You clicked on item no. $position", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@MainActivity, CatsActivity::class.java)
            intent.putExtra("heading", newArrayList[position].heading)
            intent.putExtra("imageId", newArrayList[position].titleImage)
            intent.putExtra("cats", cats[position])
            startActivity(intent)
            }
        })
    }
}