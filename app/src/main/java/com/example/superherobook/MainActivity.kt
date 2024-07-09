package com.example.superherobook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superherobook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var superHeroList: ArrayList<SuperHero>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val superman = SuperHero("Superman", "Gazeteci", R.drawable.superman)
        val batman = SuperHero("Batman", "Patron", R.drawable.batman)
        val ironman = SuperHero("Ironman", "Holding Sahibi", R.drawable.ironman)
        val aquaman = SuperHero("Aquaman", "Kral", R.drawable.aquaman)

        superHeroList = arrayListOf(superman, batman, ironman, aquaman)

        val adapter = SuperHeroAdapter(superHeroList)
        binding.superHeroRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.superHeroRecyclerView.adapter = adapter

    }
}