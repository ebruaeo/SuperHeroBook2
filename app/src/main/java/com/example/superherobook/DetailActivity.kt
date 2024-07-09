package com.example.superherobook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superherobook.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       // val adapterdenGelenIntent = intent
       // val secilenKahraman =
         //   adapterdenGelenIntent.getSerializableExtra("secilenKahraman") as SuperHero

val secilenKahraman = MySingleton.secilenSuperKahraman
        secilenKahraman?.let {
            binding.imageView.setImageResource(secilenKahraman.picture)
            binding.nameTextView.text = secilenKahraman.name
            binding.meslekTextView.text = secilenKahraman.job
        }


    }
}