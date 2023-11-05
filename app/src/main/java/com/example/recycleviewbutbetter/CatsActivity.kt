package com.example.recycleviewbutbetter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recycleviewbutbetter.databinding.ActivityCatsBinding

class CatsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnBack.setOnClickListener {
                val intentToMainActivity = Intent(this@CatsActivity, MainActivity::class.java)
                startActivity(intentToMainActivity)
            }
        }

        val headingCats: TextView = binding.heading
        val mainCats: TextView = binding.cats
        val imageCats: ImageView = binding.imageHeading

        val bundle: Bundle? = intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val cats = bundle.getString("cats")

        headingCats.text = heading
        mainCats.text = cats
        imageCats.setImageResource(imageId)
    }
}
