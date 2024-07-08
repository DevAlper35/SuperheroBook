package com.mudurlu.superherobook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mudurlu.superherobook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var superHeroListesi: ArrayList<SuperHero>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superman = SuperHero("Süperman","Clark Kent", "Gazeteci",R.drawable.superman)
        val batman = SuperHero("Batman","Bruce Wayne", "İş Adamı", R.drawable.batman)
        val hulk = SuperHero("Hulk","Bruce Banner","Doktor", R.drawable.hulk)
        val ironman = SuperHero("Ironman","Tony Stark", "Milyoner", R.drawable.ironman)
        val spiderman = SuperHero("Spiderman","Peter Parker", "Öğrenci", R.drawable.spiderman)

        superHeroListesi = arrayListOf(superman, batman,hulk,ironman,spiderman)

        val adapter = SuperHeroAdaptor(superHeroListesi)
        binding.superHeroRecycler.layoutManager = LinearLayoutManager(this)
        binding.superHeroRecycler.adapter = adapter
    }
}